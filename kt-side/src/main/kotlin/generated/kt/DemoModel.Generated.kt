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
 * #### Generated from [Model.kt:28]
 */
class DemoModel private constructor(
    private val _boolean_property: RdOptionalProperty<Boolean>,
    private val _boolean_array: RdOptionalProperty<BooleanArray>,
    private val _scalar: RdOptionalProperty<MyScalar>,
    private val _ubyte: RdOptionalProperty<UByte>,
    private val _ubyte_array: RdOptionalProperty<UByteArray>,
    private val _list: RdList<Int>,
    private val _set: RdSet<Int>,
    private val _mapLongToString: RdMap<Long, String>,
    private val _call: RdCall<Char, String>,
    private val _callback: RdCall<String, Int>,
    private val _interned_string: RdOptionalProperty<String>,
    private val _polymorphic: RdOptionalProperty<Base>,
    private val _polymorphic_open: RdOptionalProperty<OpenDerived>,
    private val _enum: RdOptionalProperty<MyEnum>,
    private val _date: RdOptionalProperty<Date>,
    private val _duration: RdOptionalProperty<Duration>,
    private val _property_with_default: RdProperty<String>,
    private val _if: RdOptionalProperty<Class>,
    private val _my_scalars: RdOptionalProperty<List<MyScalar>>,
    private val _list_of_derived: RdOptionalProperty<List<Derived>>,
    private val _list_of_base: RdOptionalProperty<List<Base>>,
    private val _struct_with_open_field: RdOptionalProperty<StructWithOpenStructField>,
    private val _extList: RdList<ClassWithExt>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            serializers.register(Class)
            serializers.register(MyEnum.marshaller)
            serializers.register(MyInitializedEnum.marshaller)
            serializers.register(Flags.marshaller)
            serializers.register(MyScalar)
            serializers.register(ConstUtil)
            serializers.register(OpenClass)
            serializers.register(Derived)
            serializers.register(Open)
            serializers.register(OpenDerived)
            serializers.register(StructWithOpenStructField)
            serializers.register(ComplicatedPair)
            serializers.register(ClassWithExt)
            serializers.register(ClassWithStructArrayField)
            serializers.register(OpenStructInField)
            serializers.register(Base_Unknown)
            serializers.register(OpenClass_Unknown)
            serializers.register(Open_Unknown)
            serializers.register(OpenDerived_Unknown)
            serializers.register(OpenStructInField_Unknown)
        }
        
        
        @JvmStatic
        @JvmName("internalCreateModel")
        @Deprecated("Use create instead", ReplaceWith("create(lifetime, protocol)"))
        internal fun createModel(lifetime: Lifetime, protocol: IProtocol): DemoModel  {
            @Suppress("DEPRECATION")
            return create(lifetime, protocol)
        }
        
        @JvmStatic
        @Deprecated("Use protocol.demoModel or revise the extension scope instead", ReplaceWith("protocol.demoModel"))
        fun create(lifetime: Lifetime, protocol: IProtocol): DemoModel  {
            DemoRoot.register(protocol.serializers)
            
            return DemoModel()
        }
        
        private val __StringInternedAtProtocolSerializer = FrameworkMarshallers.String.interned("Protocol")
        private val __MyScalarListSerializer = MyScalar.list()
        private val __DerivedListSerializer = Derived.list()
        private val __BaseListSerializer = AbstractPolymorphic(Base).list()
        
        const val serializationHash = 126375891868995923L
        
        const val const_toplevel : Boolean = true
        const val const_for_default : String = "192"
    }
    override val serializersOwner: ISerializersOwner get() = DemoModel
    override val serializationHash: Long get() = DemoModel.serializationHash
    
    //fields
    val boolean_property: IOptProperty<Boolean> get() = _boolean_property
    val boolean_array: IOptProperty<BooleanArray> get() = _boolean_array
    val scalar: IOptProperty<MyScalar> get() = _scalar
    val ubyte: IOptProperty<UByte> get() = _ubyte
    val ubyte_array: IOptProperty<UByteArray> get() = _ubyte_array
    val list: IMutableViewableList<Int> get() = _list
    val `set`: IMutableViewableSet<Int> get() = _set
    val mapLongToString: IMutableViewableMap<Long, String> get() = _mapLongToString
    val call: IRdCall<Char, String> get() = _call
    val callback: IRdEndpoint<String, Int> get() = _callback
    val interned_string: IOptProperty<String> get() = _interned_string
    val polymorphic: IOptProperty<Base> get() = _polymorphic
    val polymorphic_open: IOptProperty<OpenDerived> get() = _polymorphic_open
    val `enum`: IOptProperty<MyEnum> get() = _enum
    val date: IOptProperty<Date> get() = _date
    val duration: IOptProperty<Duration> get() = _duration
    val property_with_default: IProperty<String> get() = _property_with_default
    val `if`: IOptProperty<Class> get() = _if
    val my_scalars: IOptProperty<List<MyScalar>> get() = _my_scalars
    val list_of_derived: IOptProperty<List<Derived>> get() = _list_of_derived
    val list_of_base: IOptProperty<List<Base>> get() = _list_of_base
    val struct_with_open_field: IOptProperty<StructWithOpenStructField> get() = _struct_with_open_field
    val extList: IMutableViewableList<ClassWithExt> get() = _extList
    //methods
    //initializer
    init {
        _boolean_property.optimizeNested = true
        _boolean_array.optimizeNested = true
        _scalar.optimizeNested = true
        _ubyte.optimizeNested = true
        _ubyte_array.optimizeNested = true
        _list.optimizeNested = true
        _set.optimizeNested = true
        _mapLongToString.optimizeNested = true
        _interned_string.optimizeNested = true
        _polymorphic.optimizeNested = true
        _polymorphic_open.optimizeNested = true
        _enum.optimizeNested = true
        _date.optimizeNested = true
        _duration.optimizeNested = true
        _property_with_default.optimizeNested = true
        _if.optimizeNested = true
        _my_scalars.optimizeNested = true
        _list_of_derived.optimizeNested = true
        _list_of_base.optimizeNested = true
        _struct_with_open_field.optimizeNested = true
    }
    
    init {
        bindableChildren.add("boolean_property" to _boolean_property)
        bindableChildren.add("boolean_array" to _boolean_array)
        bindableChildren.add("scalar" to _scalar)
        bindableChildren.add("ubyte" to _ubyte)
        bindableChildren.add("ubyte_array" to _ubyte_array)
        bindableChildren.add("list" to _list)
        bindableChildren.add("set" to _set)
        bindableChildren.add("mapLongToString" to _mapLongToString)
        bindableChildren.add("call" to _call)
        bindableChildren.add("callback" to _callback)
        bindableChildren.add("interned_string" to _interned_string)
        bindableChildren.add("polymorphic" to _polymorphic)
        bindableChildren.add("polymorphic_open" to _polymorphic_open)
        bindableChildren.add("enum" to _enum)
        bindableChildren.add("date" to _date)
        bindableChildren.add("duration" to _duration)
        bindableChildren.add("property_with_default" to _property_with_default)
        bindableChildren.add("if" to _if)
        bindableChildren.add("my_scalars" to _my_scalars)
        bindableChildren.add("list_of_derived" to _list_of_derived)
        bindableChildren.add("list_of_base" to _list_of_base)
        bindableChildren.add("struct_with_open_field" to _struct_with_open_field)
        bindableChildren.add("extList" to _extList)
    }
    
    //secondary constructor
    private constructor(
    ) : this(
        RdOptionalProperty<Boolean>(FrameworkMarshallers.Bool),
        RdOptionalProperty<BooleanArray>(FrameworkMarshallers.BooleanArray),
        RdOptionalProperty<MyScalar>(MyScalar),
        RdOptionalProperty<UByte>(FrameworkMarshallers.UByte),
        RdOptionalProperty<UByteArray>(FrameworkMarshallers.UByteArray),
        RdList<Int>(FrameworkMarshallers.Int),
        RdSet<Int>(FrameworkMarshallers.Int),
        RdMap<Long, String>(FrameworkMarshallers.Long, FrameworkMarshallers.String),
        RdCall<Char, String>(FrameworkMarshallers.Char, FrameworkMarshallers.String),
        RdCall<String, Int>(FrameworkMarshallers.String, FrameworkMarshallers.Int),
        RdOptionalProperty<String>(__StringInternedAtProtocolSerializer),
        RdOptionalProperty<Base>(AbstractPolymorphic(Base)),
        RdOptionalProperty<OpenDerived>(AbstractPolymorphic(OpenDerived)),
        RdOptionalProperty<MyEnum>(MyEnum.marshaller),
        RdOptionalProperty<Date>(FrameworkMarshallers.DateTime),
        RdOptionalProperty<Duration>(FrameworkMarshallers.TimeSpan),
        RdProperty<String>(const_for_default, FrameworkMarshallers.String),
        RdOptionalProperty<Class>(Class),
        RdOptionalProperty<List<MyScalar>>(__MyScalarListSerializer),
        RdOptionalProperty<List<Derived>>(__DerivedListSerializer),
        RdOptionalProperty<List<Base>>(__BaseListSerializer),
        RdOptionalProperty<StructWithOpenStructField>(StructWithOpenStructField),
        RdList<ClassWithExt>(ClassWithExt)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("DemoModel (")
        printer.indent {
            print("boolean_property = "); _boolean_property.print(printer); println()
            print("boolean_array = "); _boolean_array.print(printer); println()
            print("scalar = "); _scalar.print(printer); println()
            print("ubyte = "); _ubyte.print(printer); println()
            print("ubyte_array = "); _ubyte_array.print(printer); println()
            print("list = "); _list.print(printer); println()
            print("set = "); _set.print(printer); println()
            print("mapLongToString = "); _mapLongToString.print(printer); println()
            print("call = "); _call.print(printer); println()
            print("callback = "); _callback.print(printer); println()
            print("interned_string = "); _interned_string.print(printer); println()
            print("polymorphic = "); _polymorphic.print(printer); println()
            print("polymorphic_open = "); _polymorphic_open.print(printer); println()
            print("enum = "); _enum.print(printer); println()
            print("date = "); _date.print(printer); println()
            print("duration = "); _duration.print(printer); println()
            print("property_with_default = "); _property_with_default.print(printer); println()
            print("if = "); _if.print(printer); println()
            print("my_scalars = "); _my_scalars.print(printer); println()
            print("list_of_derived = "); _list_of_derived.print(printer); println()
            print("list_of_base = "); _list_of_base.print(printer); println()
            print("struct_with_open_field = "); _struct_with_open_field.print(printer); println()
            print("extList = "); _extList.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): DemoModel   {
        return DemoModel(
            _boolean_property.deepClonePolymorphic(),
            _boolean_array.deepClonePolymorphic(),
            _scalar.deepClonePolymorphic(),
            _ubyte.deepClonePolymorphic(),
            _ubyte_array.deepClonePolymorphic(),
            _list.deepClonePolymorphic(),
            _set.deepClonePolymorphic(),
            _mapLongToString.deepClonePolymorphic(),
            _call.deepClonePolymorphic(),
            _callback.deepClonePolymorphic(),
            _interned_string.deepClonePolymorphic(),
            _polymorphic.deepClonePolymorphic(),
            _polymorphic_open.deepClonePolymorphic(),
            _enum.deepClonePolymorphic(),
            _date.deepClonePolymorphic(),
            _duration.deepClonePolymorphic(),
            _property_with_default.deepClonePolymorphic(),
            _if.deepClonePolymorphic(),
            _my_scalars.deepClonePolymorphic(),
            _list_of_derived.deepClonePolymorphic(),
            _list_of_base.deepClonePolymorphic(),
            _struct_with_open_field.deepClonePolymorphic(),
            _extList.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
    override val extThreading: ExtThreadingKind get() = ExtThreadingKind.Default
}
val IProtocol.demoModel get() = getOrCreateExtension(DemoModel::class) { @Suppress("DEPRECATION") DemoModel.create(lifetime, this) }



/**
 * #### Generated from [Model.kt:91]
 */
abstract class Base (
) : IPrintable {
    //companion
    
    companion object : IAbstractDeclaration<Base> {
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): Base  {
            val objectStartPosition = buffer.position
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return Base_Unknown(unknownId, unknownBytes)
        }
        
        
        const val const_base : Char = 'B'
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


class Base_Unknown (
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : Base (
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<Base_Unknown> {
        override val _type: KClass<Base_Unknown> = Base_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): Base_Unknown  {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: Base_Unknown)  {
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
        
        other as Base_Unknown
        
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("Base_Unknown (")
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:29]
 */
data class Class (
    val `true`: String
) : IPrintable {
    //companion
    
    companion object : IMarshaller<Class> {
        override val _type: KClass<Class> = Class::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): Class  {
            val `true` = buffer.readString()
            return Class(`true`)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: Class)  {
            buffer.writeString(value.`true`)
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
        
        other as Class
        
        if (`true` != other.`true`) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + `true`.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("Class (")
        printer.indent {
            print("true = "); `true`.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:129]
 */
class ClassWithExt (
    val key: Int
) : RdBindableBase() {
    //companion
    
    companion object : IMarshaller<ClassWithExt> {
        override val _type: KClass<ClassWithExt> = ClassWithExt::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): ClassWithExt  {
            val _id = RdId.read(buffer)
            val key = buffer.readInt()
            return ClassWithExt(key).withId(_id)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: ClassWithExt)  {
            value.rdid.write(buffer)
            buffer.writeInt(value.key)
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
        printer.println("ClassWithExt (")
        printer.indent {
            print("key = "); key.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): ClassWithExt   {
        return ClassWithExt(
            key
        )
    }
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:133]
 */
class ClassWithStructArrayField (
    val arrayField: Array<MyScalar>
) : RdBindableBase() {
    //companion
    
    companion object : IMarshaller<ClassWithStructArrayField> {
        override val _type: KClass<ClassWithStructArrayField> = ClassWithStructArrayField::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): ClassWithStructArrayField  {
            val _id = RdId.read(buffer)
            val arrayField = buffer.readArray {MyScalar.read(ctx, buffer)}
            return ClassWithStructArrayField(arrayField).withId(_id)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: ClassWithStructArrayField)  {
            value.rdid.write(buffer)
            buffer.writeArray(value.arrayField) { MyScalar.write(ctx, buffer, it) }
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
        printer.println("ClassWithStructArrayField (")
        printer.indent {
            print("arrayField = "); arrayField.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): ClassWithStructArrayField   {
        return ClassWithStructArrayField(
            arrayField
        )
    }
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:122]
 */
data class ComplicatedPair (
    val first: Derived,
    val second: Derived
) : IPrintable {
    //companion
    
    companion object : IMarshaller<ComplicatedPair> {
        override val _type: KClass<ComplicatedPair> = ComplicatedPair::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): ComplicatedPair  {
            val first = Derived.read(ctx, buffer)
            val second = Derived.read(ctx, buffer)
            return ComplicatedPair(first, second)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: ComplicatedPair)  {
            Derived.write(ctx, buffer, value.first)
            Derived.write(ctx, buffer, value.second)
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
        
        other as ComplicatedPair
        
        if (first != other.first) return false
        if (second != other.second) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + first.hashCode()
        __r = __r*31 + second.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("ComplicatedPair (")
        printer.indent {
            print("first = "); first.print(printer); println()
            print("second = "); second.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:76]
 */
class ConstUtil (
) : IPrintable {
    //companion
    
    companion object : IMarshaller<ConstUtil> {
        override val _type: KClass<ConstUtil> = ConstUtil::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): ConstUtil  {
            return ConstUtil()
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: ConstUtil)  {
        }
        
        
        const val const_byte : Byte = 0
        const val const_short : Short = 32767
        const val const_int : Int = 2147483647
        const val const_long : Long = 9223372036854775807L
        const val const_ubyte : UByte = 255u
        const val const_ushort : UShort = 65535u
        const val const_uint : UInt = 4294967295u
        const val const_ulong : ULong = 18446744073709551615u
        const val const_float : Float = 0.0f
        const val const_double : Double = 0.0
        const val const_string : String = "const_string_value"
        val const_enum : MyEnum = MyEnum.default
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as ConstUtil
        
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("ConstUtil (")
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:100]
 */
class Derived (
    val string: String
) : Base (
) {
    //companion
    
    companion object : IMarshaller<Derived> {
        override val _type: KClass<Derived> = Derived::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): Derived  {
            val string = buffer.readString()
            return Derived(string)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: Derived)  {
            buffer.writeString(value.string)
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
        
        other as Derived
        
        if (string != other.string) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + string.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("Derived (")
        printer.indent {
            print("string = "); string.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:52]
 */
enum class Flags {
    anyFlag, 
    ktFlag, 
    netFlag, 
    cppFlag;
    
    companion object {
        val marshaller = FrameworkMarshallers.enumSet<Flags>()
        
    }
}


/**
 * @property default Dummy field with keyword-like name
 * #### Generated from [Model.kt:33]
 */
enum class MyEnum {
    
    /**
     * Dummy field with keyword-like name
     */
    default, 
    kt, 
    net, 
    cpp;
    
    companion object {
        val marshaller = FrameworkMarshallers.enum<MyEnum>()
        
        const val all : Int = 0
    }
}


/**
 * #### Generated from [Model.kt:42]
 */
enum class MyInitializedEnum {
    zero, 
    hundred, 
    two, 
    three, 
    ten, 
    five, 
    six;
    
    companion object {
        val marshaller = FrameworkMarshallers.enum<MyInitializedEnum>()
        
    }
}


/**
 * #### Generated from [Model.kt:59]
 */
data class MyScalar (
    val bool: Boolean,
    val byte: Byte,
    val short: Short,
    val int: Int,
    val long: Long,
    val float: Float,
    val double: Double,
    val unsigned_byte: UByte,
    val unsigned_short: UShort,
    val unsigned_int: UInt,
    val unsigned_long: ULong,
    val `enum`: MyEnum,
    val flags: EnumSet<Flags>,
    val myInitializedEnum: MyInitializedEnum
) : IPrintable {
    //companion
    
    companion object : IMarshaller<MyScalar> {
        override val _type: KClass<MyScalar> = MyScalar::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): MyScalar  {
            val bool = buffer.readBool()
            val byte = buffer.readByte()
            val short = buffer.readShort()
            val int = buffer.readInt()
            val long = buffer.readLong()
            val float = buffer.readFloat()
            val double = buffer.readDouble()
            val unsigned_byte = buffer.readUByte()
            val unsigned_short = buffer.readUShort()
            val unsigned_int = buffer.readUInt()
            val unsigned_long = buffer.readULong()
            val `enum` = buffer.readEnum<MyEnum>()
            val flags = buffer.readEnumSet<Flags>()
            val myInitializedEnum = buffer.readEnum<MyInitializedEnum>()
            return MyScalar(bool, byte, short, int, long, float, double, unsigned_byte, unsigned_short, unsigned_int, unsigned_long, `enum`, flags, myInitializedEnum)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: MyScalar)  {
            buffer.writeBool(value.bool)
            buffer.writeByte(value.byte)
            buffer.writeShort(value.short)
            buffer.writeInt(value.int)
            buffer.writeLong(value.long)
            buffer.writeFloat(value.float)
            buffer.writeDouble(value.double)
            buffer.writeUByte(value.unsigned_byte)
            buffer.writeUShort(value.unsigned_short)
            buffer.writeUInt(value.unsigned_int)
            buffer.writeULong(value.unsigned_long)
            buffer.writeEnum(value.`enum`)
            buffer.writeEnumSet(value.flags)
            buffer.writeEnum(value.myInitializedEnum)
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
        
        other as MyScalar
        
        if (bool != other.bool) return false
        if (byte != other.byte) return false
        if (short != other.short) return false
        if (int != other.int) return false
        if (long != other.long) return false
        if (float != other.float) return false
        if (double != other.double) return false
        if (unsigned_byte != other.unsigned_byte) return false
        if (unsigned_short != other.unsigned_short) return false
        if (unsigned_int != other.unsigned_int) return false
        if (unsigned_long != other.unsigned_long) return false
        if (`enum` != other.`enum`) return false
        if (flags != other.flags) return false
        if (myInitializedEnum != other.myInitializedEnum) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + bool.hashCode()
        __r = __r*31 + byte.hashCode()
        __r = __r*31 + short.hashCode()
        __r = __r*31 + int.hashCode()
        __r = __r*31 + long.hashCode()
        __r = __r*31 + float.hashCode()
        __r = __r*31 + double.hashCode()
        __r = __r*31 + unsigned_byte.hashCode()
        __r = __r*31 + unsigned_short.hashCode()
        __r = __r*31 + unsigned_int.hashCode()
        __r = __r*31 + unsigned_long.hashCode()
        __r = __r*31 + `enum`.hashCode()
        __r = __r*31 + flags.hashCode()
        __r = __r*31 + myInitializedEnum.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("MyScalar (")
        printer.indent {
            print("bool = "); bool.print(printer); println()
            print("byte = "); byte.print(printer); println()
            print("short = "); short.print(printer); println()
            print("int = "); int.print(printer); println()
            print("long = "); long.print(printer); println()
            print("float = "); float.print(printer); println()
            print("double = "); double.print(printer); println()
            print("unsigned_byte = "); unsigned_byte.print(printer); println()
            print("unsigned_short = "); unsigned_short.print(printer); println()
            print("unsigned_int = "); unsigned_int.print(printer); println()
            print("unsigned_long = "); unsigned_long.print(printer); println()
            print("enum = "); `enum`.print(printer); println()
            print("flags = "); flags.print(printer); println()
            print("myInitializedEnum = "); myInitializedEnum.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:104]
 */
open class Open (
    val openString: String
) : Base (
) {
    //companion
    
    companion object : IMarshaller<Open>, IAbstractDeclaration<Open> {
        override val _type: KClass<Open> = Open::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): Open  {
            val openString = buffer.readString()
            return Open(openString)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: Open)  {
            buffer.writeString(value.openString)
        }
        
        
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): Open  {
            val objectStartPosition = buffer.position
            val openString = buffer.readString()
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return Open_Unknown(openString, unknownId, unknownBytes)
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
        
        other as Open
        
        if (openString != other.openString) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + openString.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("Open (")
        printer.indent {
            print("openString = "); openString.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:95]
 */
open class OpenClass protected constructor(
    protected val _string: RdOptionalProperty<String>,
    val `field`: String
) : RdBindableBase() {
    //companion
    
    companion object : IMarshaller<OpenClass>, IAbstractDeclaration<OpenClass> {
        override val _type: KClass<OpenClass> = OpenClass::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): OpenClass  {
            val _id = RdId.read(buffer)
            val _string = RdOptionalProperty.read(ctx, buffer, FrameworkMarshallers.String)
            val `field` = buffer.readString()
            return OpenClass(_string, `field`).withId(_id)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: OpenClass)  {
            value.rdid.write(buffer)
            RdOptionalProperty.write(ctx, buffer, value._string)
            buffer.writeString(value.`field`)
        }
        
        
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): OpenClass  {
            val objectStartPosition = buffer.position
            val _id = RdId.read(buffer)
            val _string = RdOptionalProperty.read(ctx, buffer, FrameworkMarshallers.String)
            val `field` = buffer.readString()
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return OpenClass_Unknown(_string, `field`, unknownId, unknownBytes).withId(_id)
        }
        
    }
    //fields
    val string: IOptProperty<String> get() = _string
    //methods
    //initializer
    init {
        _string.optimizeNested = true
    }
    
    init {
        bindableChildren.add("string" to _string)
    }
    
    //secondary constructor
    constructor(
        `field`: String
    ) : this(
        RdOptionalProperty<String>(FrameworkMarshallers.String),
        `field`
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("OpenClass (")
        printer.indent {
            print("string = "); _string.print(printer); println()
            print("field = "); `field`.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): OpenClass   {
        return OpenClass(
            _string.deepClonePolymorphic(),
            `field`
        )
    }
    //contexts
    //threading
}


class OpenClass_Unknown (
    _string: RdOptionalProperty<String>,
    `field`: String,
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : OpenClass (
    _string,
    `field`
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<OpenClass_Unknown> {
        override val _type: KClass<OpenClass_Unknown> = OpenClass_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): OpenClass_Unknown  {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: OpenClass_Unknown)  {
            value.rdid.write(buffer)
            RdOptionalProperty.write(ctx, buffer, value._string)
            buffer.writeString(value.`field`)
            buffer.writeByteArrayRaw(value.unknownBytes)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    constructor(
        `field`: String,
        unknownId: RdId,
        unknownBytes: ByteArray
    ) : this(
        RdOptionalProperty<String>(FrameworkMarshallers.String),
        `field`,
        unknownId,
        unknownBytes
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("OpenClass_Unknown (")
        printer.indent {
            print("string = "); _string.print(printer); println()
            print("field = "); `field`.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): OpenClass_Unknown   {
        return OpenClass_Unknown(
            _string.deepClonePolymorphic(),
            `field`,
            unknownId,
            unknownBytes
        )
    }
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:108]
 */
open class OpenDerived (
    val openDerivedString: String,
    openString: String
) : Open (
    openString
) {
    //companion
    
    companion object : IMarshaller<OpenDerived>, IAbstractDeclaration<OpenDerived> {
        override val _type: KClass<OpenDerived> = OpenDerived::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): OpenDerived  {
            val openString = buffer.readString()
            val openDerivedString = buffer.readString()
            return OpenDerived(openDerivedString, openString)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: OpenDerived)  {
            buffer.writeString(value.openString)
            buffer.writeString(value.openDerivedString)
        }
        
        
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): OpenDerived  {
            val objectStartPosition = buffer.position
            val openDerivedString = buffer.readString()
            val openString = buffer.readString()
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return OpenDerived_Unknown(openDerivedString, openString, unknownId, unknownBytes)
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
        
        other as OpenDerived
        
        if (openDerivedString != other.openDerivedString) return false
        if (openString != other.openString) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + openDerivedString.hashCode()
        __r = __r*31 + openString.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("OpenDerived (")
        printer.indent {
            print("openDerivedString = "); openDerivedString.print(printer); println()
            print("openString = "); openString.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


class OpenDerived_Unknown (
    openDerivedString: String,
    openString: String,
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : OpenDerived (
    openDerivedString,
    openString
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<OpenDerived_Unknown> {
        override val _type: KClass<OpenDerived_Unknown> = OpenDerived_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): OpenDerived_Unknown  {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: OpenDerived_Unknown)  {
            buffer.writeString(value.openDerivedString)
            buffer.writeString(value.openString)
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
        
        other as OpenDerived_Unknown
        
        if (openDerivedString != other.openDerivedString) return false
        if (openString != other.openString) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + openDerivedString.hashCode()
        __r = __r*31 + openString.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("OpenDerived_Unknown (")
        printer.indent {
            print("openDerivedString = "); openDerivedString.print(printer); println()
            print("openString = "); openString.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:113]
 */
open class OpenStructInField (
    val underflow0: String,
    val underflow1: String,
    val value: Int,
    val overflow0: String,
    val overflow1: String
) : IPrintable {
    //companion
    
    companion object : IMarshaller<OpenStructInField>, IAbstractDeclaration<OpenStructInField> {
        override val _type: KClass<OpenStructInField> = OpenStructInField::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): OpenStructInField  {
            val underflow0 = buffer.readString()
            val underflow1 = buffer.readString()
            val value = buffer.readInt()
            val overflow0 = buffer.readString()
            val overflow1 = buffer.readString()
            return OpenStructInField(underflow0, underflow1, value, overflow0, overflow1)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: OpenStructInField)  {
            buffer.writeString(value.underflow0)
            buffer.writeString(value.underflow1)
            buffer.writeInt(value.value)
            buffer.writeString(value.overflow0)
            buffer.writeString(value.overflow1)
        }
        
        
        override fun readUnknownInstance(ctx: SerializationCtx, buffer: AbstractBuffer, unknownId: RdId, size: Int): OpenStructInField  {
            val objectStartPosition = buffer.position
            val underflow0 = buffer.readString()
            val underflow1 = buffer.readString()
            val value = buffer.readInt()
            val overflow0 = buffer.readString()
            val overflow1 = buffer.readString()
            val unknownBytes = ByteArray(objectStartPosition + size - buffer.position)
            buffer.readByteArrayRaw(unknownBytes)
            return OpenStructInField_Unknown(underflow0, underflow1, value, overflow0, overflow1, unknownId, unknownBytes)
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
        
        other as OpenStructInField
        
        if (underflow0 != other.underflow0) return false
        if (underflow1 != other.underflow1) return false
        if (value != other.value) return false
        if (overflow0 != other.overflow0) return false
        if (overflow1 != other.overflow1) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + underflow0.hashCode()
        __r = __r*31 + underflow1.hashCode()
        __r = __r*31 + value.hashCode()
        __r = __r*31 + overflow0.hashCode()
        __r = __r*31 + overflow1.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("OpenStructInField (")
        printer.indent {
            print("underflow0 = "); underflow0.print(printer); println()
            print("underflow1 = "); underflow1.print(printer); println()
            print("value = "); value.print(printer); println()
            print("overflow0 = "); overflow0.print(printer); println()
            print("overflow1 = "); overflow1.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


class OpenStructInField_Unknown (
    underflow0: String,
    underflow1: String,
    value: Int,
    overflow0: String,
    overflow1: String,
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : OpenStructInField (
    underflow0,
    underflow1,
    value,
    overflow0,
    overflow1
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<OpenStructInField_Unknown> {
        override val _type: KClass<OpenStructInField_Unknown> = OpenStructInField_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): OpenStructInField_Unknown  {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: OpenStructInField_Unknown)  {
            buffer.writeString(value.underflow0)
            buffer.writeString(value.underflow1)
            buffer.writeInt(value.value)
            buffer.writeString(value.overflow0)
            buffer.writeString(value.overflow1)
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
        
        other as OpenStructInField_Unknown
        
        if (underflow0 != other.underflow0) return false
        if (underflow1 != other.underflow1) return false
        if (value != other.value) return false
        if (overflow0 != other.overflow0) return false
        if (overflow1 != other.overflow1) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + underflow0.hashCode()
        __r = __r*31 + underflow1.hashCode()
        __r = __r*31 + value.hashCode()
        __r = __r*31 + overflow0.hashCode()
        __r = __r*31 + overflow1.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("OpenStructInField_Unknown (")
        printer.indent {
            print("underflow0 = "); underflow0.print(printer); println()
            print("underflow1 = "); underflow1.print(printer); println()
            print("value = "); value.print(printer); println()
            print("overflow0 = "); overflow0.print(printer); println()
            print("overflow1 = "); overflow1.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


class Open_Unknown (
    openString: String,
    override val unknownId: RdId,
    val unknownBytes: ByteArray
) : Open (
    openString
), IUnknownInstance {
    //companion
    
    companion object : IMarshaller<Open_Unknown> {
        override val _type: KClass<Open_Unknown> = Open_Unknown::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): Open_Unknown  {
            throw NotImplementedError("Unknown instances should not be read via serializer")
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: Open_Unknown)  {
            buffer.writeString(value.openString)
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
        
        other as Open_Unknown
        
        if (openString != other.openString) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + openString.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("Open_Unknown (")
        printer.indent {
            print("openString = "); openString.print(printer); println()
        }
        printer.print(")")
    }
    
    override fun toString() = PrettyPrinter().singleLine().also { print(it) }.toString()
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [Model.kt:112]
 */
data class StructWithOpenStructField (
    val `inner`: OpenStructInField
) : IPrintable {
    //companion
    
    companion object : IMarshaller<StructWithOpenStructField> {
        override val _type: KClass<StructWithOpenStructField> = StructWithOpenStructField::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): StructWithOpenStructField  {
            val `inner` = ctx.serializers.readPolymorphic<OpenStructInField>(ctx, buffer, OpenStructInField)
            return StructWithOpenStructField(`inner`)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: StructWithOpenStructField)  {
            ctx.serializers.writePolymorphic(ctx, buffer, value.`inner`)
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
        
        other as StructWithOpenStructField
        
        if (`inner` != other.`inner`) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + `inner`.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("StructWithOpenStructField (")
        printer.indent {
            print("inner = "); `inner`.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}
