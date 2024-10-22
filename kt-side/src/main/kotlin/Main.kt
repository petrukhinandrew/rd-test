package org.example

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.util.catch
import com.jetbrains.rd.util.lifetime.Lifetime
import com.jetbrains.rd.util.lifetime.isAlive
import com.jetbrains.rd.util.reactive.IScheduler
import com.jetbrains.rider.model.*
import java.util.concurrent.ConcurrentLinkedQueue

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
//        serializers.register(FrameworkMarshallers.create<IlAsm>(writer = { buffer, IlAsm ->
//
//        }, reader = { buffer -> }, predefinedId = IlAsm::class.simpleName.getPlatformIndependentHash().toInt()));

        sigModel.asmResponse.advise(lifetime) { response ->
            response.forEach { dto ->
                IlInstance.cache.put(dto)
            }
            response.forEach { dto -> IlInstance.cache.get(dto).attach() }
        }
//            println("got response for ${response.path}")
//            asms[response.id] = IlAsm(response.path)
//            response.types.forEach { type ->
//                types[type.id] = IlType(type.name)
//                type.fields.forEach { field ->
//                    fields[field.id] = IlField(field.name)
//                }
//            }
//            println("insts alloc done")
//            asms[response.id]!!.types = response.types.map { t -> types[t.id]!! }
//            response.types.forEach { type ->
//                types[type.id]!!.fields = type.fields.map { f ->
//                    fields[f.id]!!
//                }
//                type.fields.forEach { field ->
//                    fields[field.id]!!.declType = types[field.declTypeId]!!
//                    fields[field.id]!!.fieldType = types[field.fieldTypeId]!!
//                }
//            }
//            println("inst mapping done")
//            println(fields[5]!!.fieldType === fields[8]!!.fieldType)
//            println(fields[5]!!.fieldType == fields[8]!!.fieldType)
//            println(fields[5]!!.declType === fields[5]!!.fieldType)
//            println(fields[5]!!.declType == fields[5]!!.fieldType)
//
//        }
//        println("requesting root asm path")
//        sigModel.asmRequest.fire(Request("root asm path"))
//        println("request fired")

    }
}

interface IlInstance {
    fun attach()

    companion object {
        val cache = IlCache()
    }
}

class IlAsm(private val dto: IlAsmDto) : IlInstance {
    val location = dto.location
    val types: MutableList<IlType> = mutableListOf()

    override fun attach() {}
}

class IlType(private val dto: IlTypeDto) : IlInstance {
    lateinit var declAsm: IlAsm
    val fields: MutableList<IlField> = mutableListOf()
    val methods: MutableList<IlMethod> = mutableListOf()
    override fun attach() {
        declAsm = IlInstance.cache.getAsm(AsmCacheKey(dto.id.asm))
        declAsm.types.add(this)
    }
}

class IlField(private val dto: IlFieldDto) : IlInstance {
    lateinit var declType: IlType
    lateinit var fieldType: IlType
    val isStatic: Boolean = dto.isStatic
    val name: String = dto.name

    override fun attach() {
        declType = IlInstance.cache.getType(dto.declType)
        declType.fields.add(this)
        fieldType = IlInstance.cache.getType(dto.fieldType)

    }
}

class IlMethod(private val dto: IlMethodDto) : IlInstance {
    lateinit var declType: IlType
    lateinit var returnType: IlType
    val name: String = dto.name
    val parametes: MutableList<IlParameter> = dto.parameters.map { IlParameter(it) }.toMutableList()

    override fun attach() {
        declType = IlInstance.cache.getType(dto.declType)
        declType.methods.add(this)
        returnType = IlInstance.cache.getType(dto.returnType)
        parametes.forEach { it.attach() }
    }
}

class IlParameter(private val dto: IlParameterDto) : IlInstance {
    lateinit var paramType: IlType
    val name: String = dto.name
    override fun attach() {
        paramType = IlInstance.cache.getType(dto.type)
    }

}

class IlCache {
    private val assemblies: MutableMap<AsmCacheKey, IlAsm> = mutableMapOf()
    private val types: MutableMap<CacheKey, IlType> = mutableMapOf()
    private val fields: MutableMap<CacheKey, IlField> = mutableMapOf()
    private val methods: MutableMap<CacheKey, IlMethod> = mutableMapOf()
    fun put(dto: IlDto) {
        when (dto) {
            is IlAsmDto -> putAsm(dto)
            is IlTypeDto -> putType(dto)
            is IlFieldDto -> putField(dto)
            is IlMethodDto -> putMethod(dto)
        }
    }

    private fun putAsm(asm: IlAsmDto) {
        assemblies[asm.id] = IlAsm(asm)
    }

    fun get(dto: IlDto): IlInstance =
        when (dto) {
            is IlAsmDto -> getAsm(dto.id)
            is IlTypeDto -> getType(dto.id)
            is IlFieldDto -> getField(dto.id)
            is IlMethodDto -> getMethod(dto.id)
            else -> throw UnsupportedOperationException("unknown dto $dto")
        }

    fun getAsm(key: AsmCacheKey): IlAsm = assemblies[key]!!

    private fun putType(type: IlTypeDto) {
        types[type.id] = IlType(type)
    }

    fun getType(key: CacheKey): IlType = types[key]!!

    private fun putField(field: IlFieldDto) {
        fields[field.id] = IlField(field)
    }

    fun getField(key: CacheKey): IlField = fields[key]!!
    private fun putMethod(method: IlMethodDto) {
        methods[method.id] = IlMethod(method)
    }

    fun getMethod(key: CacheKey): IlMethod = methods[key]!!
}

//class IlSerializer(val cache: IlCache) {
//    fun serialize(buffer: AbstractBuffer, dto: IlDto) {
//
//    }
//
//    fun deserialize(buffer: AbstractBuffer): IlDto {
//
//    }
//
//    companion object {
//        private val marshallerIdHash: Int by lazy {
//            IlDto::class.simpleName.getPlatformIndependentHash().toInt()
//        }
//
//        private fun marshaller(cache: IlCache): UniversalMarshaller<IlDto> {
//            val serializer = IlSerializer(cache)
//            return FrameworkMarshallers.create<IlDto>(
//                writer = { buffer, dto ->
//                    serializer.serialize(buffer, dto)
//                },
//                reader = { buffer ->
//                    serializer.deserialize(buffer)
//                },
//                predefinedId = marshallerIdHash
//            )
//        }
//
//        fun Serializers.registerIlSerializer(cache: IlCache) {
//            register(marshaller(cache))
//        }
//    }
//}
