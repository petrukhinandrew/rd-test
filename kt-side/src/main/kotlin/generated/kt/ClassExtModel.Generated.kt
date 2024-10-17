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
 * #### Generated from [Model.kt:196]
 */
class ClassExtModel private constructor(
    private val _values: RdSignal<Int>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
        }
        
        
        
        
        
        const val serializationHash = 9039760352823104056L
        
    }
    override val serializersOwner: ISerializersOwner get() = ClassExtModel
    override val serializationHash: Long get() = ClassExtModel.serializationHash
    
    //fields
    val values: ISignal<Int> get() = _values
    //methods
    //initializer
    init {
        bindableChildren.add("values" to _values)
    }
    
    //secondary constructor
    internal constructor(
    ) : this(
        RdSignal<Int>(FrameworkMarshallers.Int)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("ClassExtModel (")
        printer.indent {
            print("values = "); _values.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): ClassExtModel   {
        return ClassExtModel(
            _values.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
    override val extThreading: ExtThreadingKind get() = ExtThreadingKind.Default
}
val ClassWithExt.classExtModel get() = getOrCreateExtension("classExtModel", ::ClassExtModel)

