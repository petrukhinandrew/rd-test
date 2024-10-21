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
 * #### Generated from [Model.kt:21]
 */
class IlModel private constructor(
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            serializers.register(IlAsmDto)
            serializers.register(IlTypeDto)
            serializers.register(IlFieldDto)
        }
        
        
        @JvmStatic
        @JvmName("internalCreateModel")
        @Deprecated("Use create instead", ReplaceWith("create(lifetime, protocol)"))
        internal fun createModel(lifetime: Lifetime, protocol: IProtocol): IlModel  {
            @Suppress("DEPRECATION")
            return create(lifetime, protocol)
        }
        
        @JvmStatic
        @Deprecated("Use protocol.ilModel or revise the extension scope instead", ReplaceWith("protocol.ilModel"))
        fun create(lifetime: Lifetime, protocol: IProtocol): IlModel  {
            DemoRoot.register(protocol.serializers)
            
            return IlModel()
        }
        
        
        const val serializationHash = 6447058661582492715L
        
    }
    override val serializersOwner: ISerializersOwner get() = IlModel
    override val serializationHash: Long get() = IlModel.serializationHash
    
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlModel (")
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): IlModel   {
        return IlModel(
        )
    }
    //contexts
    //threading
    override val extThreading: ExtThreadingKind get() = ExtThreadingKind.Default
}
val IProtocol.ilModel get() = getOrCreateExtension(IlModel::class) { @Suppress("DEPRECATION") IlModel.create(lifetime, this) }



/**
 * #### Generated from [Model.kt:22]
 */
data class IlAsmDto (
    val id: Int,
    val path: String,
    val types: List<IlTypeDto>
) : IPrintable {
    //companion
    
    companion object : IMarshaller<IlAsmDto> {
        override val _type: KClass<IlAsmDto> = IlAsmDto::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlAsmDto  {
            val id = buffer.readInt()
            val path = buffer.readString()
            val types = buffer.readList { IlTypeDto.read(ctx, buffer) }
            return IlAsmDto(id, path, types)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlAsmDto)  {
            buffer.writeInt(value.id)
            buffer.writeString(value.path)
            buffer.writeList(value.types) { v -> IlTypeDto.write(ctx, buffer, v) }
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
        
        other as IlAsmDto
        
        if (id != other.id) return false
        if (path != other.path) return false
        if (types != other.types) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + id.hashCode()
        __r = __r*31 + path.hashCode()
        __r = __r*31 + types.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlAsmDto (")
        printer.indent {
            print("id = "); id.print(printer); println()
            print("path = "); path.print(printer); println()
            print("types = "); types.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:32]
 */
data class IlFieldDto (
    val id: Int,
    val name: String,
    val declTypeId: Int,
    val fieldTypeId: Int
) : IPrintable {
    //companion
    
    companion object : IMarshaller<IlFieldDto> {
        override val _type: KClass<IlFieldDto> = IlFieldDto::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlFieldDto  {
            val id = buffer.readInt()
            val name = buffer.readString()
            val declTypeId = buffer.readInt()
            val fieldTypeId = buffer.readInt()
            return IlFieldDto(id, name, declTypeId, fieldTypeId)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlFieldDto)  {
            buffer.writeInt(value.id)
            buffer.writeString(value.name)
            buffer.writeInt(value.declTypeId)
            buffer.writeInt(value.fieldTypeId)
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
        
        other as IlFieldDto
        
        if (id != other.id) return false
        if (name != other.name) return false
        if (declTypeId != other.declTypeId) return false
        if (fieldTypeId != other.fieldTypeId) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + id.hashCode()
        __r = __r*31 + name.hashCode()
        __r = __r*31 + declTypeId.hashCode()
        __r = __r*31 + fieldTypeId.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlFieldDto (")
        printer.indent {
            print("id = "); id.print(printer); println()
            print("name = "); name.print(printer); println()
            print("declTypeId = "); declTypeId.print(printer); println()
            print("fieldTypeId = "); fieldTypeId.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:27]
 */
data class IlTypeDto (
    val id: Int,
    val name: String,
    val fields: List<IlFieldDto>
) : IPrintable {
    //companion
    
    companion object : IMarshaller<IlTypeDto> {
        override val _type: KClass<IlTypeDto> = IlTypeDto::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlTypeDto  {
            val id = buffer.readInt()
            val name = buffer.readString()
            val fields = buffer.readList { IlFieldDto.read(ctx, buffer) }
            return IlTypeDto(id, name, fields)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlTypeDto)  {
            buffer.writeInt(value.id)
            buffer.writeString(value.name)
            buffer.writeList(value.fields) { v -> IlFieldDto.write(ctx, buffer, v) }
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
        
        other as IlTypeDto
        
        if (id != other.id) return false
        if (name != other.name) return false
        if (fields != other.fields) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + id.hashCode()
        __r = __r*31 + name.hashCode()
        __r = __r*31 + fields.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlTypeDto (")
        printer.indent {
            print("id = "); id.print(printer); println()
            print("name = "); name.print(printer); println()
            print("fields = "); fields.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}
