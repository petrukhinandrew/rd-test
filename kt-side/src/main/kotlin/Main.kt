package org.example

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.framework.base.deepClonePolymorphic
import com.jetbrains.rd.util.catch
import com.jetbrains.rd.util.lifetime.Lifetime
import com.jetbrains.rd.util.lifetime.isAlive
import com.jetbrains.rd.util.reactive.IScheduler
import com.jetbrains.rider.model.*
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
//    thread {
//        Thread.sleep(10000)
//        socketLifetimeDef.terminate()
//    }
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

//        val model = protocol.linksModel
//        var parents = listOf<ParentInst>()
//        model.parentInsts.advise(lifetime) {
//            println(it)
//            parents = it
//            println("${it[0].childB == it[1].childB} ${it[0].childB === it[1].childB}")
//        }
//        model.instStorage.advise(lifetime) {
//            println(it)
//            println(parents == it[0].parentInsts)
//        }

        val ilModel = protocol.ilModel;
        val sigModel = ilModel.ilSigModel;
        sigModel.asmResponse.advise(lifetime) { response ->
            asms[response.id] = IlAsm(response.path)
            response.types.forEach { type ->
                types[type.id] = IlType(type.name)
                type.fields.forEach { field ->
                    fields[field.id] = IlField(field.name)
                }
            }
            asms[response.id]!!.types = response.types.map{ t -> types[t.id]!!}
            response.types.forEach { type ->
                types[type.id]!!.fields = type.fields.map { f ->
                    fields[f.id]!!
                }
                type.fields.forEach { field ->
                    fields[field.id]!!.declType = types[field.declTypeId]!!
                    fields[field.id]!!.fieldType = types[field.fieldTypeId]!!
                }
            }
            println(fields[5]!!.fieldType === fields[8]!!.fieldType)
        }

        sigModel.asmRequest.fire(Request("root asm path"))
    }
}

interface IlInstance
val asms = mutableMapOf<Int, IlAsm>()
val types = mutableMapOf<Int, IlType>()
val fields = mutableMapOf<Int, IlField>()

class IlAsm(val path: String) : IlInstance {
    lateinit var types: List<IlType>
}

class IlType(val name: String) : IlInstance {
    lateinit var fields: List<IlField>
}

class IlField(val name: String) : IlInstance {
    lateinit var declType: IlType
    lateinit var fieldType: IlType
}