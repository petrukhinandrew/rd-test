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
 * #### Generated from [Model.kt:231]
 */
class ExtModel private constructor(
    private val _checker: RdSignal<Unit>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
        }
        
        
        
        
        
        const val serializationHash = 2364843396187734L
        
    }
    override val serializersOwner: ISerializersOwner get() = ExtModel
    override val serializationHash: Long get() = ExtModel.serializationHash
    
    //fields
    val checker: ISignal<Unit> get() = _checker
    //methods
    //initializer
    init {
        bindableChildren.add("checker" to _checker)
    }
    
    //secondary constructor
    internal constructor(
    ) : this(
        RdSignal<Unit>(FrameworkMarshallers.Void)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("ExtModel (")
        printer.indent {
            print("checker = "); _checker.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): ExtModel   {
        return ExtModel(
            _checker.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
    override val extThreading: ExtThreadingKind get() = ExtThreadingKind.Default
}
val DemoModel.extModel get() = getOrCreateExtension("extModel", ::ExtModel)

