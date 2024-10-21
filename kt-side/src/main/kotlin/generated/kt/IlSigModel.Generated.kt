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
 * #### Generated from [Model.kt:40]
 */
class IlSigModel private constructor(
    private val _asmRequest: RdSignal<Request>,
    private val _asmResponse: RdSignal<IlAsmDto>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            serializers.register(Request)
        }
        
        
        
        
        
        const val serializationHash = -231705078597361284L
        
    }
    override val serializersOwner: ISerializersOwner get() = IlSigModel
    override val serializationHash: Long get() = IlSigModel.serializationHash
    
    //fields
    val asmRequest: IAsyncSignal<Request> get() = _asmRequest
    val asmResponse: IAsyncSignal<IlAsmDto> get() = _asmResponse
    //methods
    //initializer
    init {
        _asmRequest.async = true
        _asmResponse.async = true
    }
    
    init {
        bindableChildren.add("asmRequest" to _asmRequest)
        bindableChildren.add("asmResponse" to _asmResponse)
    }
    
    //secondary constructor
    internal constructor(
    ) : this(
        RdSignal<Request>(Request),
        RdSignal<IlAsmDto>(IlAsmDto)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("IlSigModel (")
        printer.indent {
            print("asmRequest = "); _asmRequest.print(printer); println()
            print("asmResponse = "); _asmResponse.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): IlSigModel   {
        return IlSigModel(
            _asmRequest.deepClonePolymorphic(),
            _asmResponse.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
    override val extThreading: ExtThreadingKind get() = ExtThreadingKind.Default
}
val IlModel.ilSigModel get() = getOrCreateExtension("ilSigModel", ::IlSigModel)



/**
 * #### Generated from [Model.kt:41]
 */
data class Request (
    val rootAsm: String
) : IPrintable {
    //companion
    
    companion object : IMarshaller<Request> {
        override val _type: KClass<Request> = Request::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): Request  {
            val rootAsm = buffer.readString()
            return Request(rootAsm)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: Request)  {
            buffer.writeString(value.rootAsm)
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
        
        other as Request
        
        if (rootAsm != other.rootAsm) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + rootAsm.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("Request (")
        printer.indent {
            print("rootAsm = "); rootAsm.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}
