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
 * #### Generated from [Model.kt:92]
 */
class PrimitiveModel private constructor(
    private val _strValue: RdOptionalProperty<String>,
    private val _intValue: RdOptionalProperty<Int>,
    private val _setIntValue: RdSignal<Int>,
    private val _setStrValue: RdSignal<String>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
        }
        
        
        @JvmStatic
        @JvmName("internalCreateModel")
        @Deprecated("Use create instead", ReplaceWith("create(lifetime, protocol)"))
        internal fun createModel(lifetime: Lifetime, protocol: IProtocol): PrimitiveModel  {
            @Suppress("DEPRECATION")
            return create(lifetime, protocol)
        }
        
        @JvmStatic
        @Deprecated("Use protocol.primitiveModel or revise the extension scope instead", ReplaceWith("protocol.primitiveModel"))
        fun create(lifetime: Lifetime, protocol: IProtocol): PrimitiveModel  {
            DemoRoot.register(protocol.serializers)
            
            return PrimitiveModel()
        }
        
        
        const val serializationHash = -1621346098143554055L
        
    }
    override val serializersOwner: ISerializersOwner get() = PrimitiveModel
    override val serializationHash: Long get() = PrimitiveModel.serializationHash
    
    //fields
    val strValue: IOptProperty<String> get() = _strValue
    val intValue: IOptProperty<Int> get() = _intValue
    val setIntValue: ISignal<Int> get() = _setIntValue
    val setStrValue: ISignal<String> get() = _setStrValue
    //methods
    //initializer
    init {
        _strValue.optimizeNested = true
        _intValue.optimizeNested = true
    }
    
    init {
        bindableChildren.add("strValue" to _strValue)
        bindableChildren.add("intValue" to _intValue)
        bindableChildren.add("setIntValue" to _setIntValue)
        bindableChildren.add("setStrValue" to _setStrValue)
    }
    
    //secondary constructor
    private constructor(
    ) : this(
        RdOptionalProperty<String>(FrameworkMarshallers.String),
        RdOptionalProperty<Int>(FrameworkMarshallers.Int),
        RdSignal<Int>(FrameworkMarshallers.Int),
        RdSignal<String>(FrameworkMarshallers.String)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("PrimitiveModel (")
        printer.indent {
            print("strValue = "); _strValue.print(printer); println()
            print("intValue = "); _intValue.print(printer); println()
            print("setIntValue = "); _setIntValue.print(printer); println()
            print("setStrValue = "); _setStrValue.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): PrimitiveModel   {
        return PrimitiveModel(
            _strValue.deepClonePolymorphic(),
            _intValue.deepClonePolymorphic(),
            _setIntValue.deepClonePolymorphic(),
            _setStrValue.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
    override val extThreading: ExtThreadingKind get() = ExtThreadingKind.Default
}
val IProtocol.primitiveModel get() = getOrCreateExtension(PrimitiveModel::class) { @Suppress("DEPRECATION") PrimitiveModel.create(lifetime, this) }

