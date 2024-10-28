package org.example

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.util.catch
import com.jetbrains.rd.util.lifetime.Lifetime
import com.jetbrains.rd.util.lifetime.isAlive
import com.jetbrains.rd.util.reactive.IScheduler
import com.jetbrains.rider.model.*
import org.example.ilinstances.IlInstance
import java.io.File
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.TimeUnit

class Server(val scheduler: IScheduler, val protocol: Protocol) {
    val modelLifetime = Lifetime.Eternal.createNested()

    fun queue(action: () -> Unit) {
        scheduler.queue {
            action()
        }
    }
}

fun pumpCurrentThread(lifetime: Lifetime, initializationAction: (IScheduler) -> Unit) {
    val actions = ConcurrentLinkedQueue<() -> Unit>()
    val currentThread = Thread.currentThread()
    val scheduler = object : IScheduler {
        override val isActive: Boolean
            get() = currentThread == Thread.currentThread()

        override fun flush() {
            while (true) {
                val action = actions.poll() ?: return
                if (lifetime.isAlive)
                    catch { action() }
            }
        }

        override fun queue(action: () -> Unit) {
            if (lifetime.isAlive)
                actions.add(action)
        }
    }

    initializationAction(scheduler)

    j@ while (lifetime.isAlive) {
        val action = actions.poll()
        if (action == null) {
            Thread.yield()
            continue@j
        }
        catch { action() }
    }
}

fun main() {
    val socketLifetimeDef = Lifetime.Eternal.createNested()
    val lifetime = socketLifetimeDef.lifetime

    val serializers = Serializers(MarshallersProvider.Dummy)

    pumpCurrentThread(lifetime) { scheduler ->
        val protocol = Protocol(
            "Server",
            serializers,
            Identities(IdKind.Server),
            scheduler,
            SocketWire.Server(lifetime, scheduler, 8083, "Server"),
            lifetime
        )

        val ilModel = protocol.ilModel;
        val sigModel = ilModel.ilSigModel;
        var (process, alive) = spawnDotNetProcess("/home/andrew/Documents/dotnet-tac/TACBuilder/bin/Debug/net8.0/linux-x64/")
        process.onExit().thenRun { println(".NET process shut down") }
        sigModel.asmResponse.advise(lifetime) { response ->
            response.forEach { dto ->
                IlInstance.cache.put(dto)
            }
            response.forEach { dto -> IlInstance.cache.get(dto).attach() }
            IlInstance.cache.printEntriesHierarchy()
            process.destroy()
        }

        assert(alive)
        sigModel.asmRequest.fire(Request("/home/andrew/Documents/dotnet-tac/TACBuilder.Tests/bin/Release/net8.0/linux-x64/publish/TACBuilder.Tests.dll"))
    }
}

fun spawnDotNetProcess(exePath: String): Pair<Process, Boolean> {
    val process = ProcessBuilder("./TACBuilder")
        .directory(File(exePath))
        .redirectOutput(ProcessBuilder.Redirect.INHERIT)
        .redirectError(ProcessBuilder.Redirect.INHERIT)
        .start()
    val alive = process.waitFor(10, TimeUnit.SECONDS)
    println(".NET process spawned")
    return Pair(process, alive)
}