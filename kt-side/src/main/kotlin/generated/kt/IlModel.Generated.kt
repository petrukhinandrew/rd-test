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
            serializers.register(CacheKey)
            serializers.register(AsmCacheKey)
            serializers.register(IlAsmDto)
            serializers.register(IlTypeDto)
            serializers.register(IlFieldDto)
            serializers.register(IlParameterDto)
            serializers.register(IlVarDto)
            serializers.register(IlLocalVarDto)
            serializers.register(IlTempVarDto)
            serializers.register(IlErrVarDto)
            serializers.register(IlMethodDto)
            serializers.register(IlDto_Unknown)
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
            IlRoot.register(protocol.serializers)
            
            return IlModel()
        }
        
        
        const val serializationHash = 8838680866087314158L
        
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
 * #### Generated from [Model.kt:29]
 */
data class AsmCacheKey (
    val asm: Int
) : IPrintable {
    //companion
    
    companion object : IMarshaller<AsmCacheKey> {
        override val _type: KClass<AsmCacheKey> = AsmCacheKey::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): AsmCacheKey  {
            val asm = buffer.readInt()
            return AsmCacheKey(asm)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: AsmCacheKey)  {
            buffer.writeInt(value.asm)
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
        
        other as AsmCacheKey
        
        if (asm != other.asm) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + asm.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("AsmCacheKey (")
        printer.indent {
            print("asm = "); asm.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:23]
 */
data class CacheKey (
    val asm: Int,
    val mod: Int,
    val inst: Int
) : IPrintable {
    //companion
    
    companion object : IMarshaller<CacheKey> {
        override val _type: KClass<CacheKey> = CacheKey::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): CacheKey  {
            val asm = buffer.readInt()
            val mod = buffer.readInt()
            val inst = buffer.readInt()
            return CacheKey(asm, mod, inst)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: CacheKey)  {
            buffer.writeInt(value.asm)
            buffer.writeInt(value.mod)
            buffer.writeInt(value.inst)
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
        
        other as CacheKey
        
        if (asm != other.asm) return false
        if (mod != other.mod) return false
        if (inst != other.inst) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + asm.hashCode()
        __r = __r*31 + mod.hashCode()
        __r = __r*31 + inst.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("CacheKey (")
        printer.indent {
            print("asm = "); asm.print(printer); println()
            print("mod = "); mod.print(printer); println()
            print("inst = "); inst.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:34]
 */
class IlAsmDto (
    val id: AsmCacheKey,
    val location: String
) : IlDto (
) {
    //companion
    
    companion object : IMarshaller<IlAsmDto> {
        override val _type: KClass<IlAsmDto> = IlAsmDto::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlAsmDto  {
            val id = AsmCacheKey.read(ctx, buffer)
            val location = buffer.readString()
            return IlAsmDto(id, location)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlAsmDto)  {
            AsmCacheKey.write(ctx, buffer, value.id)
            buffer.writeString(value.location)
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
        if (location != other.location) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + id.hashCode()
        __r = __r*31 + location.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlAsmDto (")
        printer.indent {
            print("id = "); id.print(printer); println()
            print("location = "); location.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:33]
 */
abstract class IlDto (
) : IPrintable {
    //companion
    
    companion object : IAbstractDeclaration<IlDto> {
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): IlDto  {
            val objectStartPosition = buffer.position
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return IlDto_Unknown(unknownId, unknownBytes)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    //hash code trait
    //pretty print
    //deepClone
    //contexts
    //threading
}


class IlDto_Unknown (
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : IlDto (
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<IlDto_Unknown> {
        override val _type: KClass<IlDto_Unknown> = IlDto_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlDto_Unknown  {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlDto_Unknown)  {
            buffer.writeByteArrayRaw(value.unknownBytes)
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
        
        other as IlDto_Unknown
        
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlDto_Unknown (")
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:71]
 */
class IlErrVarDto (
    type: CacheKey,
    index: Int
) : IlVarDto (
    type,
    index
) {
    //companion
    
    companion object : IMarshaller<IlErrVarDto> {
        override val _type: KClass<IlErrVarDto> = IlErrVarDto::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlErrVarDto  {
            val type = CacheKey.read(ctx, buffer)
            val index = buffer.readInt()
            return IlErrVarDto(type, index)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlErrVarDto)  {
            CacheKey.write(ctx, buffer, value.type)
            buffer.writeInt(value.index)
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
        
        other as IlErrVarDto
        
        if (type != other.type) return false
        if (index != other.index) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + type.hashCode()
        __r = __r*31 + index.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlErrVarDto (")
        printer.indent {
            print("type = "); type.print(printer); println()
            print("index = "); index.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:48]
 */
class IlFieldDto (
    val id: CacheKey,
    val declType: CacheKey,
    val fieldType: CacheKey,
    val isStatic: Boolean,
    val name: String
) : IlDto (
) {
    //companion
    
    companion object : IMarshaller<IlFieldDto> {
        override val _type: KClass<IlFieldDto> = IlFieldDto::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlFieldDto  {
            val id = CacheKey.read(ctx, buffer)
            val declType = CacheKey.read(ctx, buffer)
            val fieldType = CacheKey.read(ctx, buffer)
            val isStatic = buffer.readBool()
            val name = buffer.readString()
            return IlFieldDto(id, declType, fieldType, isStatic, name)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlFieldDto)  {
            CacheKey.write(ctx, buffer, value.id)
            CacheKey.write(ctx, buffer, value.declType)
            CacheKey.write(ctx, buffer, value.fieldType)
            buffer.writeBool(value.isStatic)
            buffer.writeString(value.name)
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
        if (declType != other.declType) return false
        if (fieldType != other.fieldType) return false
        if (isStatic != other.isStatic) return false
        if (name != other.name) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + id.hashCode()
        __r = __r*31 + declType.hashCode()
        __r = __r*31 + fieldType.hashCode()
        __r = __r*31 + isStatic.hashCode()
        __r = __r*31 + name.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlFieldDto (")
        printer.indent {
            print("id = "); id.print(printer); println()
            print("declType = "); declType.print(printer); println()
            print("fieldType = "); fieldType.print(printer); println()
            print("isStatic = "); isStatic.print(printer); println()
            print("name = "); name.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:67]
 */
class IlLocalVarDto (
    type: CacheKey,
    index: Int
) : IlVarDto (
    type,
    index
) {
    //companion
    
    companion object : IMarshaller<IlLocalVarDto> {
        override val _type: KClass<IlLocalVarDto> = IlLocalVarDto::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlLocalVarDto  {
            val type = CacheKey.read(ctx, buffer)
            val index = buffer.readInt()
            return IlLocalVarDto(type, index)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlLocalVarDto)  {
            CacheKey.write(ctx, buffer, value.type)
            buffer.writeInt(value.index)
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
        
        other as IlLocalVarDto
        
        if (type != other.type) return false
        if (index != other.index) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + type.hashCode()
        __r = __r*31 + index.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlLocalVarDto (")
        printer.indent {
            print("type = "); type.print(printer); println()
            print("index = "); index.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:72]
 */
class IlMethodDto (
    val id: CacheKey,
    val declType: CacheKey?,
    val returnType: CacheKey?,
    val name: String,
    val parameters: List<IlParameterDto>,
    val resolved: Boolean,
    val locals: List<IlLocalVarDto>,
    val temps: List<IlTempVarDto>,
    val errs: List<IlErrVarDto>,
    val body: List<IlStmtDto>
) : IlDto (
) {
    //companion
    
    companion object : IMarshaller<IlMethodDto> {
        override val _type: KClass<IlMethodDto> = IlMethodDto::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlMethodDto  {
            val id = CacheKey.read(ctx, buffer)
            val declType = buffer.readNullable { CacheKey.read(ctx, buffer) }
            val returnType = buffer.readNullable { CacheKey.read(ctx, buffer) }
            val name = buffer.readString()
            val parameters = buffer.readList { IlParameterDto.read(ctx, buffer) }
            val resolved = buffer.readBool()
            val locals = buffer.readList { IlLocalVarDto.read(ctx, buffer) }
            val temps = buffer.readList { IlTempVarDto.read(ctx, buffer) }
            val errs = buffer.readList { IlErrVarDto.read(ctx, buffer) }
            val body = buffer.readList { ctx.serializers.readPolymorphic<IlStmtDto>(ctx, buffer, IlStmtDto) }
            return IlMethodDto(id, declType, returnType, name, parameters, resolved, locals, temps, errs, body)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlMethodDto)  {
            CacheKey.write(ctx, buffer, value.id)
            buffer.writeNullable(value.declType) { CacheKey.write(ctx, buffer, it) }
            buffer.writeNullable(value.returnType) { CacheKey.write(ctx, buffer, it) }
            buffer.writeString(value.name)
            buffer.writeList(value.parameters) { v -> IlParameterDto.write(ctx, buffer, v) }
            buffer.writeBool(value.resolved)
            buffer.writeList(value.locals) { v -> IlLocalVarDto.write(ctx, buffer, v) }
            buffer.writeList(value.temps) { v -> IlTempVarDto.write(ctx, buffer, v) }
            buffer.writeList(value.errs) { v -> IlErrVarDto.write(ctx, buffer, v) }
            buffer.writeList(value.body) { v -> ctx.serializers.writePolymorphic(ctx, buffer, v) }
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
        
        other as IlMethodDto
        
        if (id != other.id) return false
        if (declType != other.declType) return false
        if (returnType != other.returnType) return false
        if (name != other.name) return false
        if (parameters != other.parameters) return false
        if (resolved != other.resolved) return false
        if (locals != other.locals) return false
        if (temps != other.temps) return false
        if (errs != other.errs) return false
        if (body != other.body) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + id.hashCode()
        __r = __r*31 + if (declType != null) declType.hashCode() else 0
        __r = __r*31 + if (returnType != null) returnType.hashCode() else 0
        __r = __r*31 + name.hashCode()
        __r = __r*31 + parameters.hashCode()
        __r = __r*31 + resolved.hashCode()
        __r = __r*31 + locals.hashCode()
        __r = __r*31 + temps.hashCode()
        __r = __r*31 + errs.hashCode()
        __r = __r*31 + body.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlMethodDto (")
        printer.indent {
            print("id = "); id.print(printer); println()
            print("declType = "); declType.print(printer); println()
            print("returnType = "); returnType.print(printer); println()
            print("name = "); name.print(printer); println()
            print("parameters = "); parameters.print(printer); println()
            print("resolved = "); resolved.print(printer); println()
            print("locals = "); locals.print(printer); println()
            print("temps = "); temps.print(printer); println()
            print("errs = "); errs.print(printer); println()
            print("body = "); body.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:56]
 */
class IlParameterDto (
    val index: Int,
    val type: CacheKey,
    val name: String,
    val defaultValue: String?
) : IlDto (
) {
    //companion
    
    companion object : IMarshaller<IlParameterDto> {
        override val _type: KClass<IlParameterDto> = IlParameterDto::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlParameterDto  {
            val index = buffer.readInt()
            val type = CacheKey.read(ctx, buffer)
            val name = buffer.readString()
            val defaultValue = buffer.readNullable { buffer.readString() }
            return IlParameterDto(index, type, name, defaultValue)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlParameterDto)  {
            buffer.writeInt(value.index)
            CacheKey.write(ctx, buffer, value.type)
            buffer.writeString(value.name)
            buffer.writeNullable(value.defaultValue) { buffer.writeString(it) }
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
        
        other as IlParameterDto
        
        if (index != other.index) return false
        if (type != other.type) return false
        if (name != other.name) return false
        if (defaultValue != other.defaultValue) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + index.hashCode()
        __r = __r*31 + type.hashCode()
        __r = __r*31 + name.hashCode()
        __r = __r*31 + if (defaultValue != null) defaultValue.hashCode() else 0
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlParameterDto (")
        printer.indent {
            print("index = "); index.print(printer); println()
            print("type = "); type.print(printer); println()
            print("name = "); name.print(printer); println()
            print("defaultValue = "); defaultValue.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:69]
 */
class IlTempVarDto (
    type: CacheKey,
    index: Int
) : IlVarDto (
    type,
    index
) {
    //companion
    
    companion object : IMarshaller<IlTempVarDto> {
        override val _type: KClass<IlTempVarDto> = IlTempVarDto::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlTempVarDto  {
            val type = CacheKey.read(ctx, buffer)
            val index = buffer.readInt()
            return IlTempVarDto(type, index)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlTempVarDto)  {
            CacheKey.write(ctx, buffer, value.type)
            buffer.writeInt(value.index)
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
        
        other as IlTempVarDto
        
        if (type != other.type) return false
        if (index != other.index) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + type.hashCode()
        __r = __r*31 + index.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlTempVarDto (")
        printer.indent {
            print("type = "); type.print(printer); println()
            print("index = "); index.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:39]
 */
class IlTypeDto (
    val id: CacheKey,
    val name: String,
    val genericArgs: List<CacheKey>,
    val isGenericParam: Boolean,
    val isValueType: Boolean,
    val isManaged: Boolean
) : IlDto (
) {
    //companion
    
    companion object : IMarshaller<IlTypeDto> {
        override val _type: KClass<IlTypeDto> = IlTypeDto::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlTypeDto  {
            val id = CacheKey.read(ctx, buffer)
            val name = buffer.readString()
            val genericArgs = buffer.readList { CacheKey.read(ctx, buffer) }
            val isGenericParam = buffer.readBool()
            val isValueType = buffer.readBool()
            val isManaged = buffer.readBool()
            return IlTypeDto(id, name, genericArgs, isGenericParam, isValueType, isManaged)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlTypeDto)  {
            CacheKey.write(ctx, buffer, value.id)
            buffer.writeString(value.name)
            buffer.writeList(value.genericArgs) { v -> CacheKey.write(ctx, buffer, v) }
            buffer.writeBool(value.isGenericParam)
            buffer.writeBool(value.isValueType)
            buffer.writeBool(value.isManaged)
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
        if (genericArgs != other.genericArgs) return false
        if (isGenericParam != other.isGenericParam) return false
        if (isValueType != other.isValueType) return false
        if (isManaged != other.isManaged) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + id.hashCode()
        __r = __r*31 + name.hashCode()
        __r = __r*31 + genericArgs.hashCode()
        __r = __r*31 + isGenericParam.hashCode()
        __r = __r*31 + isValueType.hashCode()
        __r = __r*31 + isManaged.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlTypeDto (")
        printer.indent {
            print("id = "); id.print(printer); println()
            print("name = "); name.print(printer); println()
            print("genericArgs = "); genericArgs.print(printer); println()
            print("isGenericParam = "); isGenericParam.print(printer); println()
            print("isValueType = "); isValueType.print(printer); println()
            print("isManaged = "); isManaged.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:62]
 */
class IlVarDto (
    val type: CacheKey,
    val index: Int
) : IlDto (
) {
    //companion
    
    companion object : IMarshaller<IlVarDto> {
        override val _type: KClass<IlVarDto> = IlVarDto::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): IlVarDto  {
            val type = CacheKey.read(ctx, buffer)
            val index = buffer.readInt()
            return IlVarDto(type, index)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: IlVarDto)  {
            CacheKey.write(ctx, buffer, value.type)
            buffer.writeInt(value.index)
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
        
        other as IlVarDto
        
        if (type != other.type) return false
        if (index != other.index) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + type.hashCode()
        __r = __r*31 + index.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlVarDto (")
        printer.indent {
            print("type = "); type.print(printer); println()
            print("index = "); index.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}
