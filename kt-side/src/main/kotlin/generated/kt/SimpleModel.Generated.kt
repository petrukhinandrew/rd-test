@file:Suppress("EXPERIMENTAL_API_USAGE","EXPERIMENTAL_UNSIGNED_LITERALS","PackageDirectoryMismatch","UnusedImport","unused","LocalVariableName","CanBeVal","PropertyName","EnumEntryName","ClassName","ObjectPropertyName","UnnecessaryVariable","SpellCheckingInspection")
package com.jetbrains.rider.model

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.framework.base.*
import com.jetbrains.rd.framework.impl.*

import com.jetbrains.rd.util.lifetime.*
import com.jetbrains.rd.util.reactive.*
import com.jetbrains.rd.util.string.*
import com.jetbrains.rd.util.*
import kotlin.time.Duration
import kotlin.reflect.KClass
import kotlin.jvm.JvmStatic



/**
 * #### Generated from [Model.kt:162]
 */
class SimpleModel private constructor(
    private val _types: RdOptionalProperty<Array<IlType>>,
    private val _instances: RdOptionalProperty<Array<IlType>>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            serializers.register(IlInstance)
            serializers.register(IlMethod)
            serializers.register(IlType)
            serializers.register(IlInstance_Unknown)
        }
        
        
        @JvmStatic
        @JvmName("internalCreateModel")
        @Deprecated("Use create instead", ReplaceWith("create(lifetime, protocol)"))
        internal fun createModel(lifetime: Lifetime, protocol: IProtocol): SimpleModel  {
            @Suppress("DEPRECATION")
            return create(lifetime, protocol)
        }
        
        @JvmStatic
        @Deprecated("Use protocol.simpleModel or revise the extension scope instead", ReplaceWith("protocol.simpleModel"))
        fun create(lifetime: Lifetime, protocol: IProtocol): SimpleModel  {
            DemoRoot.register(protocol.serializers)
            
            return SimpleModel()
        }
        
        private val __IlTypeArraySerializer = IlType.array()
        
        const val serializationHash = -8325234396836602965L
        
    }
    override val serializersOwner: ISerializersOwner get() = SimpleModel
    override val serializationHash: Long get() = SimpleModel.serializationHash
    
    //fields
    val types: IOptProperty<Array<IlType>> get() = _types
    val instances: IOptProperty<Array<IlType>> get() = _instances
    //methods
    //initializer
    init {
        bindableChildren.add("types" to _types)
        bindableChildren.add("instances" to _instances)
    }
    
    //secondary constructor
    private constructor(
    ) : this(
        RdOptionalProperty<Array<IlType>>(__IlTypeArraySerializer),
        RdOptionalProperty<Array<IlType>>(__IlTypeArraySerializer)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("SimpleModel (")
        printer.indent {
            print("types = "); _types.print(printer); println()
            print("instances = "); _instances.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): SimpleModel   {
        return SimpleModel(
            _types.deepClonePolymorphic(),
            _instances.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
    override val extThreading: ExtThreadingKind get() = ExtThreadingKind.Default
}
val IProtocol.simpleModel get() = getOrCreateExtension(SimpleModel::class) { @Suppress("DEPRECATION") SimpleModel.create(lifetime, this) }



/**
 * #### Generated from [Model.kt:163]
 */
open class IlInstance protected constructor(
    protected val _name: RdOptionalProperty<String>
) : RdBindableBase() {
    //companion
    
    companion object : IMarshaller<IlInstance>, IAbstractDeclaration<IlInstance> {
        override val _type: KClass<IlInstance> = IlInstance::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlInstance  {
            val _id = RdId.read(buffer)
            val _name = RdOptionalProperty.read(ctx, buffer, FrameworkMarshallers.String)
            return IlInstance(_name).withId(_id)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlInstance)  {
            value.rdid.write(buffer)
            RdOptionalProperty.write(ctx, buffer, value._name)
        }
        
        
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): IlInstance  {
            val objectStartPosition = buffer.position
            val _id = RdId.read(buffer)
            val _name = RdOptionalProperty.read(ctx, buffer, FrameworkMarshallers.String)
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return IlInstance_Unknown(_name, unknownId, unknownBytes).withId(_id)
        }
        
    }
    //fields
    val name: IOptProperty<String> get() = _name
    //methods
    //initializer
    init {
        _name.optimizeNested = true
    }
    
    init {
        bindableChildren.add("name" to _name)
    }
    
    //secondary constructor
    constructor(
    ) : this(
        RdOptionalProperty<String>(FrameworkMarshallers.String)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlInstance (")
        printer.indent {
            print("name = "); _name.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): IlInstance   {
        return IlInstance(
            _name.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
}


class IlInstance_Unknown (
    _name: RdOptionalProperty<String>,
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : IlInstance (
    _name
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<IlInstance_Unknown> {
        override val _type: KClass<IlInstance_Unknown> = IlInstance_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlInstance_Unknown  {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlInstance_Unknown)  {
            value.rdid.write(buffer)
            RdOptionalProperty.write(ctx, buffer, value._name)
            buffer.writeByteArrayRaw(value.unknownBytes)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    constructor(
        unknownId: RdId,
        unknownBytes: ByteArray
    ) : this(
        RdOptionalProperty<String>(FrameworkMarshallers.String),
        unknownId,
        unknownBytes
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlInstance_Unknown (")
        printer.indent {
            print("name = "); _name.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): IlInstance_Unknown   {
        return IlInstance_Unknown(
            _name.deepClonePolymorphic(),
            unknownId,
            unknownBytes
        )
    }
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:166]
 */
class IlMethod private constructor(
    _name: RdOptionalProperty<String>
) : IlInstance (
    _name
) {
    //companion
    
    companion object : IMarshaller<IlMethod> {
        override val _type: KClass<IlMethod> = IlMethod::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlMethod  {
            val _id = RdId.read(buffer)
            val _name = RdOptionalProperty.read(ctx, buffer, FrameworkMarshallers.String)
            return IlMethod(_name).withId(_id)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlMethod)  {
            value.rdid.write(buffer)
            RdOptionalProperty.write(ctx, buffer, value._name)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    constructor(
    ) : this(
        RdOptionalProperty<String>(FrameworkMarshallers.String)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlMethod (")
        printer.indent {
            print("name = "); _name.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): IlMethod   {
        return IlMethod(
            _name.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:168]
 */
class IlType private constructor(
    _name: RdOptionalProperty<String>
) : IlInstance (
    _name
) {
    //companion
    
    companion object : IMarshaller<IlType> {
        override val _type: KClass<IlType> = IlType::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlType  {
            val _id = RdId.read(buffer)
            val _name = RdOptionalProperty.read(ctx, buffer, FrameworkMarshallers.String)
            return IlType(_name).withId(_id)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlType)  {
            value.rdid.write(buffer)
            RdOptionalProperty.write(ctx, buffer, value._name)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    constructor(
    ) : this(
        RdOptionalProperty<String>(FrameworkMarshallers.String)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlType (")
        printer.indent {
            print("name = "); _name.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): IlType   {
        return IlType(
            _name.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
}
