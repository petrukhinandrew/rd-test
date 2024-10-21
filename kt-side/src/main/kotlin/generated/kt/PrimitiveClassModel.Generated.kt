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
 * #### Generated from [Model.kt:41]
 */
class PrimitiveClassModel private constructor(
    private val _setStruct: RdSignal<SimpleStruct>,
    private val _multipleStruct: RdSignal<List<SimpleStruct>>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            serializers.register(SimpleClass)
            serializers.register(SimpleStruct)
        }
        
        
        @JvmStatic
        @JvmName("internalCreateModel")
        @Deprecated("Use create instead", ReplaceWith("create(lifetime, protocol)"))
        internal fun createModel(lifetime: Lifetime, protocol: IProtocol): PrimitiveClassModel  {
            @Suppress("DEPRECATION")
            return create(lifetime, protocol)
        }
        
        @JvmStatic
        @Deprecated("Use protocol.primitiveClassModel or revise the extension scope instead", ReplaceWith("protocol.primitiveClassModel"))
        fun create(lifetime: Lifetime, protocol: IProtocol): PrimitiveClassModel  {
            DemoRoot.register(protocol.serializers)
            
            return PrimitiveClassModel()
        }
        
        private val __SimpleStructListSerializer = SimpleStruct.list()
        
        const val serializationHash = 8271082733608343902L
        
    }
    override val serializersOwner: ISerializersOwner get() = PrimitiveClassModel
    override val serializationHash: Long get() = PrimitiveClassModel.serializationHash
    
    //fields
    val setStruct: ISignal<SimpleStruct> get() = _setStruct
    val multipleStruct: ISignal<List<SimpleStruct>> get() = _multipleStruct
    //methods
    //initializer
    init {
        bindableChildren.add("setStruct" to _setStruct)
        bindableChildren.add("multipleStruct" to _multipleStruct)
    }
    
    //secondary constructor
    private constructor(
    ) : this(
        RdSignal<SimpleStruct>(SimpleStruct),
        RdSignal<List<SimpleStruct>>(__SimpleStructListSerializer)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("PrimitiveClassModel (")
        printer.indent {
            print("setStruct = "); _setStruct.print(printer); println()
            print("multipleStruct = "); _multipleStruct.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): PrimitiveClassModel   {
        return PrimitiveClassModel(
            _setStruct.deepClonePolymorphic(),
            _multipleStruct.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
    override val extThreading: ExtThreadingKind get() = ExtThreadingKind.Default
}
val IProtocol.primitiveClassModel get() = getOrCreateExtension(PrimitiveClassModel::class) { @Suppress("DEPRECATION") PrimitiveClassModel.create(lifetime, this) }



/**
 * #### Generated from [Model.kt:42]
 */
class SimpleClass (
    val strValue: String,
    val intValue: Int
) : RdBindableBase() {
    //companion
    
    companion object : IMarshaller<SimpleClass> {
        override val _type: KClass<SimpleClass> = SimpleClass::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): SimpleClass  {
            val _id = RdId.read(buffer)
            val strValue = buffer.readString()
            val intValue = buffer.readInt()
            return SimpleClass(strValue, intValue).withId(_id)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: SimpleClass)  {
            value.rdid.write(buffer)
            buffer.writeString(value.strValue)
            buffer.writeInt(value.intValue)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("SimpleClass (")
        printer.indent {
            print("strValue = "); strValue.print(printer); println()
            print("intValue = "); intValue.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): SimpleClass   {
        return SimpleClass(
            strValue,
            intValue
        )
    }
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:46]
 */
data class SimpleStruct (
    val strValue: String,
    val intValue: Int
) : IPrintable {
    //companion
    
    companion object : IMarshaller<SimpleStruct> {
        override val _type: KClass<SimpleStruct> = SimpleStruct::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): SimpleStruct  {
            val strValue = buffer.readString()
            val intValue = buffer.readInt()
            return SimpleStruct(strValue, intValue)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: SimpleStruct)  {
            buffer.writeString(value.strValue)
            buffer.writeInt(value.intValue)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as SimpleStruct
        
        if (strValue != other.strValue) return false
        if (intValue != other.intValue) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + strValue.hashCode()
        __r = __r*31 + intValue.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("SimpleStruct (")
        printer.indent {
            print("strValue = "); strValue.print(printer); println()
            print("intValue = "); intValue.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}
