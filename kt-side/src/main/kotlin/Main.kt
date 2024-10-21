package org.example

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.util.catch
import com.jetbrains.rd.util.lifetime.Lifetime
import com.jetbrains.rd.util.lifetime.isAlive
import com.jetbrains.rd.util.reactive.IScheduler
import com.jetbrains.rider.model.ParentInst
import com.jetbrains.rider.model.linksModel
import com.jetbrains.rider.model.primitiveClassModel
import com.jetbrains.rider.model.primitiveModel
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.concurrent.thread

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
    thread {
        Thread.sleep(10000)
        socketLifetimeDef.terminate()
    }
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

//        val model = protocol.primitiveModel
//        val intSet = model.setIntValue
//        intSet.advise(lifetime) {
//            println("got set int $it")
//        }
//        val strSet = model.setStrValue
//        strSet.advise(lifetime) {
//            println("got set str $it")
//        }

//        val model = protocol.primitiveClassModel
//        val structSig = model.setStruct;
//        structSig.advise(lifetime) {
//            println("struct sig ${it}")
//        }
//        model.multipleStruct.advise(lifetime) {
//            println("multiple struct sig ${it}")
//        }
        val model = protocol.linksModel
        var parents = listOf<ParentInst>()
        model.parentInsts.advise(lifetime) {
            println(it)
            parents = it
            println("${it[0].childB == it[1].childB} ${it[0].childB === it[1].childB}")
        }
        model.instStorage.advise(lifetime) {
            println(it)
            println(parents == it[0].parentInsts)
        }
    }
}