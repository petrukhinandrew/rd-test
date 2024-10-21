@file:Suppress("unused")

package org.example.model

import com.jetbrains.rd.generator.nova.*
import com.jetbrains.rd.generator.nova.csharp.CSharp50Generator
import com.jetbrains.rd.generator.nova.kotlin.Kotlin11Generator
import com.jetbrains.rd.generator.paths.csDirectorySystemPropertyKey
import com.jetbrains.rd.generator.paths.ktDirectorySystemPropertyKey
import com.jetbrains.rd.generator.paths.outputDirectory
import org.example.model.SimpleModel.ilType

const val folder = "demo"

object DemoRoot : Root(
    Kotlin11Generator(FlowTransform.AsIs, "demo", outputDirectory(ktDirectorySystemPropertyKey, folder)),
    CSharp50Generator(FlowTransform.Reversed, "demo", outputDirectory(csDirectorySystemPropertyKey, folder))
)


object IlModel : Ext(DemoRoot) {
    public val IlAsmDto = structdef {
        field("id", PredefinedType.int)
        field("path", PredefinedType.string)
        field("types", immutableList(IlTypeDto))
    }
    private val IlTypeDto = structdef {
        field("id", PredefinedType.int)
        field("name", PredefinedType.string)
        field("fields", immutableList(IlFieldDto))
    }
    private val IlFieldDto = structdef {
        field("id", PredefinedType.int)
        field("name", PredefinedType.string)
        field("declTypeId", PredefinedType.int)
        field("fieldTypeId", PredefinedType.int)
    }
}

object IlSigModel: Ext(IlModel) {
    private val request = structdef {
        field("rootAsm", PredefinedType.string)
    }

    init {
        signal("asmRequest", request).apply { async }
        signal("asmResponse", IlModel.IlAsmDto).apply { async }
    }
}


object LinksModel : Ext(DemoRoot) {
    private val parentInst = structdef {
        field("childA", childA)
        field("childB", childB)
    }
    private val childA = structdef {
        field("name", PredefinedType.string)
    }
    private val childB = structdef {
        field("id", PredefinedType.int)
    }
    private val instStorage = structdef {
        field("parentInsts", immutableList(parentInst))
        field("childrenA", immutableList(childA))
        field("childrenB", immutableList(childB))
    }

    init {
        signal("parentInsts", immutableList(parentInst))
        signal("instStorage", immutableList(instStorage))
    }
}

object PrimitiveClassModel : Ext(DemoRoot) {
    private val simpleClass = classdef {
        field("strValue", PredefinedType.string)
        field("intValue", PredefinedType.int)
    }
    private val simpleStruct = structdef {
        field("strValue", PredefinedType.string)
        field("intValue", PredefinedType.int)
    }

    init {
//        signal("setClass", simpleClass)
        signal("setStruct", simpleStruct)
        signal("multipleStruct", immutableList(simpleStruct))
    }
}

object PrimitiveModel : Ext(DemoRoot) {
    init {
        property("strValue", PredefinedType.string)
        property("intValue", PredefinedType.int)
        signal("setIntValue", PredefinedType.int)
        signal("setStrValue", PredefinedType.string)
    }
}

@ExperimentalUnsignedTypes
object DemoModel : Ext(DemoRoot) {
    private val `class` = structdef("class") {
        field("true", PredefinedType.string)
    }

    private var MyScalar = structdef {
        field("bool", PredefinedType.bool)
        field("byte", PredefinedType.byte)
        field("short", PredefinedType.short)
        field("int", PredefinedType.int)
        field("long", PredefinedType.long)
        field("float", PredefinedType.float)
        field("double", PredefinedType.double)
        field("unsigned_byte", PredefinedType.ubyte)
        field("unsigned_short", PredefinedType.ushort)
        field("unsigned_int", PredefinedType.uint)
        field("unsigned_long", PredefinedType.ulong)
    }

    private var ConstUtil = structdef {
        const("const_byte", PredefinedType.byte, 0)
        const("const_short", PredefinedType.short, Short.MAX_VALUE)
        const("const_int", PredefinedType.int, Int.MAX_VALUE)
        const("const_long", PredefinedType.long, Long.MAX_VALUE)
        const("const_ubyte", PredefinedType.ubyte, UByte.MAX_VALUE)
        const("const_ushort", PredefinedType.ushort, UShort.MAX_VALUE)
        const("const_uint", PredefinedType.uint, UInt.MAX_VALUE)
        const("const_ulong", PredefinedType.ulong, ULong.MAX_VALUE)
        const("const_float", PredefinedType.float, 0f)
        const("const_double", PredefinedType.double, 0.0)
        const("const_string", PredefinedType.string, "const_string_value")
    }

    private var Base = basestruct {
        const("const_base", PredefinedType.char, 'B')
    }

    private var OpenClass = openclass {
        property("string", PredefinedType.string)
        field("field", PredefinedType.string)
    }

    private var Derived = structdef extends Base {
        field("string", PredefinedType.string)
    }

    private var Open = openstruct extends Base {
        field("openString", PredefinedType.string)
    }

    private var OpenDerived = openstruct extends Open {
        field("openDerivedString", PredefinedType.string)
    }

    private var StructWithOpenStructField = structdef {
        field("inner", openstruct("OpenStructInField") {
            field("underflow0", PredefinedType.string)
            field("underflow1", PredefinedType.string)
            field("value", PredefinedType.int)
            field("overflow0", PredefinedType.string)
            field("overflow1", PredefinedType.string)
        })
    }

    private var complicatedPair = structdef {
        field("first", Derived)
        field("second", Derived)
    }.apply {
        setting(GeneratorBase.AllowDeconstruct)
    }

    internal var classWithExt = classdef {
        field("key", PredefinedType.int)
    }

    private var ClassWithStructArrayField = classdef {
        field("arrayField", array(MyScalar))
    }

    init {
        property("boolean_property", PredefinedType.bool)

        property("boolean_array", array(PredefinedType.bool))

        property("scalar", MyScalar)

        property("ubyte", PredefinedType.ubyte)

        property("ubyte_array", array(PredefinedType.ubyte))

        list("list", PredefinedType.int)

        set("set", PredefinedType.int)

        map("mapLongToString", PredefinedType.long, PredefinedType.string)

        call("call", PredefinedType.char, PredefinedType.string)

        callback("callback", PredefinedType.string, PredefinedType.int)

        property("interned_string", PredefinedType.string.interned(ProtocolInternScope))

        property("polymorphic", Base)

        property("polymorphic_open", OpenDerived)

        property("date", PredefinedType.dateTime)

        property("duration", PredefinedType.timeSpan)

        const("const_toplevel", PredefinedType.bool, true)

        val cc = const("const_for_default", PredefinedType.string, "192")

        property("property_with_default", cc)

        property("if", `class`)

        property("my_scalars", immutableList(MyScalar))
        property("list_of_derived", immutableList(Derived))
        property("list_of_base", immutableList(Base))

        property("struct_with_open_field", StructWithOpenStructField)

        list("extList", classWithExt)
    }
}

@ExperimentalUnsignedTypes
object ExtModel : Ext(DemoModel) {
    init {
        signal("checker", PredefinedType.void)
    }
}

@ExperimentalUnsignedTypes
object ClassExtModel : Ext(DemoModel.classWithExt) {
    init {
        signal("values", PredefinedType.int)
    }
}

object SimpleModel : Ext(DemoRoot) {
    private val ilInstance = openclass {
        property("name", PredefinedType.string)
    }
    public val ilMethod = classdef extends ilInstance {
    }
    public val ilType = classdef extends ilInstance {

    }

    init {
        property("types", array(ilType))
        property("instances", array(ilInstance))
    }
}

@ExperimentalUnsignedTypes
object SimpleExtModel : Ext(SimpleModel) {
    init {
        signal("checker", PredefinedType.void)
    }
}