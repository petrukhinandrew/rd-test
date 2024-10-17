package org.example

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.util.catch
import com.jetbrains.rd.util.lifetime.Lifetime
import com.jetbrains.rd.util.lifetime.isAlive
import com.jetbrains.rd.util.reactive.IScheduler
import com.jetbrains.rd.util.reactive.fire
import com.jetbrains.rd.util.threading.SingleThreadScheduler
import com.jetbrains.rider.model.demoModel
import com.jetbrains.rider.model.extModel
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
    pumpCurrentThread(lifetime) { scheduler ->
        val protocol = Protocol(
            "Server",
            Serializers(),
            Identities(IdKind.Server),
            scheduler,
            SocketWire.Server(lifetime, scheduler, 8083, "Server"),
            lifetime
        )
        val server = Server(scheduler, protocol)
        val signal = server.protocol.demoModel.extModel.checker
        signal.fire()
        signal.fire()
        signal.fire()
        signal.advise(lifetime) {
            println("hzcallback")
        }
    }
}