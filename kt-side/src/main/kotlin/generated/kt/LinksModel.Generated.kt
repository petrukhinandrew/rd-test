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
 * #### Generated from [Model.kt:19]
 */
class LinksModel private constructor(
    private val _parentInsts: RdSignal<List<ParentInst>>,
    private val _instStorage: RdSignal<List<InstStorage>>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            serializers.register(ParentInst)
            serializers.register(ChildA)
            serializers.register(ChildB)
            serializers.register(InstStorage)
        }
        
        
        @JvmStatic
        @JvmName("internalCreateModel")
        @Deprecated("Use create instead", ReplaceWith("create(lifetime, protocol)"))
        internal fun createModel(lifetime: Lifetime, protocol: IProtocol): LinksModel  {
            @Suppress("DEPRECATION")
            return create(lifetime, protocol)
        }
        
        @JvmStatic
        @Deprecated("Use protocol.linksModel or revise the extension scope instead", ReplaceWith("protocol.linksModel"))
        fun create(lifetime: Lifetime, protocol: IProtocol): LinksModel  {
            DemoRoot.register(protocol.serializers)
            
            return LinksModel()
        }
        
        private val __ParentInstListSerializer = ParentInst.list()
        private val __InstStorageListSerializer = InstStorage.list()
        
        const val serializationHash = 3319301644439084295L
        
    }
    override val serializersOwner: ISerializersOwner get() = LinksModel
    override val serializationHash: Long get() = LinksModel.serializationHash
    
    //fields
    val parentInsts: ISignal<List<ParentInst>> get() = _parentInsts
    val instStorage: ISignal<List<InstStorage>> get() = _instStorage
    //methods
    //initializer
    init {
        bindableChildren.add("parentInsts" to _parentInsts)
        bindableChildren.add("instStorage" to _instStorage)
    }
    
    //secondary constructor
    private constructor(
    ) : this(
        RdSignal<List<ParentInst>>(__ParentInstListSerializer),
        RdSignal<List<InstStorage>>(__InstStorageListSerializer)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("LinksModel (")
        printer.indent {
            print("parentInsts = "); _parentInsts.print(printer); println()
            print("instStorage = "); _instStorage.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): LinksModel   {
        return LinksModel(
            _parentInsts.deepClonePolymorphic(),
            _instStorage.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
    override val extThreading: ExtThreadingKind get() = ExtThreadingKind.Default
}
val IProtocol.linksModel get() = getOrCreateExtension(LinksModel::class) { @Suppress("DEPRECATION") LinksModel.create(lifetime, this) }



/**
 * #### Generated from [Model.kt:24]
 */
data class ChildA (
    val name: String
) : IPrintable {
    //companion
    
    companion object : IMarshaller<ChildA> {
        override val _type: KClass<ChildA> = ChildA::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): ChildA  {
            val name = buffer.readString()
            return ChildA(name)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: ChildA)  {
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
        
        other as ChildA
        
        if (name != other.name) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + name.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("ChildA (")
        printer.indent {
            print("name = "); name.print(printer); println()
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
data class ChildB (
    val id: Int
) : IPrintable {
    //companion
    
    companion object : IMarshaller<ChildB> {
        override val _type: KClass<ChildB> = ChildB::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): ChildB  {
            val id = buffer.readInt()
            return ChildB(id)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: ChildB)  {
            buffer.writeInt(value.id)
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
        
        other as ChildB
        
        if (id != other.id) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + id.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("ChildB (")
        printer.indent {
            print("id = "); id.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:30]
 */
data class InstStorage (
    val parentInsts: List<ParentInst>,
    val childrenA: List<ChildA>,
    val childrenB: List<ChildB>
) : IPrintable {
    //companion
    
    companion object : IMarshaller<InstStorage> {
        override val _type: KClass<InstStorage> = InstStorage::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): InstStorage  {
            val parentInsts = buffer.readList { ParentInst.read(ctx, buffer) }
            val childrenA = buffer.readList { ChildA.read(ctx, buffer) }
            val childrenB = buffer.readList { ChildB.read(ctx, buffer) }
            return InstStorage(parentInsts, childrenA, childrenB)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: InstStorage)  {
            buffer.writeList(value.parentInsts) { v -> ParentInst.write(ctx, buffer, v) }
            buffer.writeList(value.childrenA) { v -> ChildA.write(ctx, buffer, v) }
            buffer.writeList(value.childrenB) { v -> ChildB.write(ctx, buffer, v) }
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
        
        other as InstStorage
        
        if (parentInsts != other.parentInsts) return false
        if (childrenA != other.childrenA) return false
        if (childrenB != other.childrenB) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + parentInsts.hashCode()
        __r = __r*31 + childrenA.hashCode()
        __r = __r*31 + childrenB.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("InstStorage (")
        printer.indent {
            print("parentInsts = "); parentInsts.print(printer); println()
            print("childrenA = "); childrenA.print(printer); println()
            print("childrenB = "); childrenB.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:20]
 */
data class ParentInst (
    val childA: ChildA,
    val childB: ChildB
) : IPrintable {
    //companion
    
    companion object : IMarshaller<ParentInst> {
        override val _type: KClass<ParentInst> = ParentInst::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): ParentInst  {
            val childA = ChildA.read(ctx, buffer)
            val childB = ChildB.read(ctx, buffer)
            return ParentInst(childA, childB)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: ParentInst)  {
            ChildA.write(ctx, buffer, value.childA)
            ChildB.write(ctx, buffer, value.childB)
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
        
        other as ParentInst
        
        if (childA != other.childA) return false
        if (childB != other.childB) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + childA.hashCode()
        __r = __r*31 + childB.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("ParentInst (")
        printer.indent {
            print("childA = "); childA.print(printer); println()
            print("childB = "); childB.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}
