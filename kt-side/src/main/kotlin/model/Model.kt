@file:Suppress("unused")

package org.example.model

import com.jetbrains.rd.generator.nova.*
import com.jetbrains.rd.generator.nova.csharp.CSharp50Generator
import com.jetbrains.rd.generator.nova.kotlin.Kotlin11Generator
import com.jetbrains.rd.generator.paths.csDirectorySystemPropertyKey
import com.jetbrains.rd.generator.paths.ktDirectorySystemPropertyKey
import com.jetbrains.rd.generator.paths.outputDirectory
import org.example.model.IlModel.extends

const val folder = "Il"

object IlRoot : Root(
    Kotlin11Generator(FlowTransform.AsIs, "Il", outputDirectory(ktDirectorySystemPropertyKey, folder)),
    CSharp50Generator(FlowTransform.Reversed, "Il", outputDirectory(csDirectorySystemPropertyKey, folder))
)


object IlModel : Ext(IlRoot) {

    val cacheKey = structdef {
        field("asm", PredefinedType.int)
        field("mod", PredefinedType.int)
        field("inst", PredefinedType.int)
    }

    private val asmCacheKey = structdef {
        field("asm", PredefinedType.int)
    }

    val IlDto = basestruct {}
    private val IlAsmDto = structdef {
        field("id", asmCacheKey)
        field("location", PredefinedType.string)
    } extends IlDto

    private val IlTypeDto = structdef {
        field("id", cacheKey)
        field("name", PredefinedType.string)
        field("genericArgs", immutableList(cacheKey))
        field("isGenericParam", PredefinedType.bool)
        field("isValueType", PredefinedType.bool)
        field("isManaged", PredefinedType.bool)
    } extends IlDto

    private val IlFieldDto = structdef {
        field("id", cacheKey)
        field("declType", cacheKey)
        field("fieldType", cacheKey)
        field("isStatic", PredefinedType.bool)
        field("name", PredefinedType.string)
    } extends IlDto

    private val IlParameterDto = structdef {
        field("index", PredefinedType.int)
        field("type", cacheKey)
        field("name", PredefinedType.string)
        field("defaultValue", PredefinedType.string.nullable)
    } extends IlDto
    private val IlVarDto = structdef {
        field("type", cacheKey)
        field("index", PredefinedType.int)
    } extends IlDto

    private val IlLocalVarDto = structdef {
    } extends IlVarDto
    private val IlTempVarDto = structdef {
    } extends IlVarDto
    private val IlErrVarDto = structdef {} extends IlVarDto
    private val IlMethodDto = structdef {
        field("id", cacheKey)
        field("declType", cacheKey.nullable)
        field("returnType", cacheKey.nullable)
        field("name", PredefinedType.string)
        field("parameters", immutableList(IlParameterDto))
        field("resolved", PredefinedType.bool)
        field("locals", immutableList(IlLocalVarDto))
        field("temps", immutableList(IlTempVarDto))
        field("errs", immutableList(IlErrVarDto))
        field("body", immutableList(IlMethodBodyModel.IlStmtDto))
    } extends IlDto


}

object IlMethodBodyModel : Ext(IlRoot) {
    private val IlExprDto = structdef {
        field("type", IlModel.cacheKey)
    }
    private val IlValueDto = basestruct {} extends IlExprDto
    private val IlConstDto = basestruct {} extends IlValueDto
    private val IlNumConstDto = basestruct {} extends IlConstDto

    private val IlByteConstDto = structdef { field("value", PredefinedType.byte) } extends IlNumConstDto
    private val IlIntConstDto = structdef { field("value", PredefinedType.int) } extends IlNumConstDto
    private val IlLongConstDto = structdef { field("value", PredefinedType.long) } extends IlNumConstDto
    private val IlFloatConstDto = structdef { field("value", PredefinedType.float) } extends IlNumConstDto
    private val IlDoubleConstDto = structdef { field("value", PredefinedType.double) } extends IlNumConstDto

    private val IlNullDto = structdef {} extends IlConstDto
    private val IlBoolConstDto = structdef { field("value", PredefinedType.bool) } extends IlConstDto
    private val IlStringConstDto = structdef { field("value", PredefinedType.string) } extends IlConstDto

    private val IlTypeRefDto = structdef { field("referencedType", IlModel.cacheKey) } extends IlConstDto
    private val IlMethodRefDto = structdef { field("method", IlModel.cacheKey) } extends IlConstDto
    private val IlFieldRefDto = structdef { field("field", IlModel.cacheKey) } extends IlConstDto

    private val IlUnaryOpDto = structdef { field("operand", IlExprDto) } extends IlExprDto
    private val IlBinaryOpDto = structdef {
        field("lhs", IlExprDto)
        field("rhs", IlExprDto)
    } extends IlExprDto

    private val IlInitExprDto = structdef {
        field("targetType", IlModel.cacheKey)
    } extends IlExprDto
    private val IlNewExprDto = structdef {
        field("targetType", IlModel.cacheKey)
        field("args", immutableList(IlExprDto))
    } extends IlExprDto

    private val IlSizeOfExprDto = structdef {
        field("targetType", IlModel.cacheKey)
    } extends IlExprDto

    private val IlFieldAccessDto = structdef {
        field("instance", IlExprDto.nullable)
        field("field", IlModel.cacheKey)
    } extends IlValueDto
    private val IlArrayAccessDto = structdef {
        field("array", IlExprDto)
        field("index", IlExprDto)
    } extends IlValueDto

    private val IlNewArrayExprDto = structdef {
        field("elementType", IlModel.cacheKey)
        field("size", IlExprDto)
    } extends IlExprDto
    private val IlArrayLengthExprDto = structdef { field("array", IlExprDto) } extends IlExprDto
    private val IlCallDto = structdef {
        field("method", IlModel.cacheKey)
        field("args", immutableList(IlModel.cacheKey))
    } extends IlExprDto

    private val IlCastExprDto = basestruct {} extends IlExprDto
    private val IlConvExprDto = structdef {} extends IlExprDto
    private val IlBoxExprDto = structdef {} extends IlExprDto
    private val IlUnboxExprDto = structdef {} extends IlExprDto
    private val IlCastClassExprDto = structdef {} extends IlExprDto
    private val IlIsInstExprDto = structdef {} extends IlExprDto

    private val IlRefExprDto = basestruct {} extends IlValueDto
    private val IlDerefExprDto = basestruct {} extends IlValueDto

    private val IlManagedRefExprDto = basestruct {} extends IlRefExprDto
    private val IlUnmanagedRefExprDto = basestruct {} extends IlRefExprDto
    private val IlManagedDerefExprDto = basestruct {} extends IlDerefExprDto
    private val IlUnmanagedDerefExprDto = basestruct {} extends IlDerefExprDto

    private val IlStackAllocExprDto = structdef {} extends IlExprDto

    val IlStmtDto = basestruct {}

    private val IlAssignStmtDto = structdef {
        field("lhs", IlValueDto)
        field("rhs", IlExprDto)
    } extends IlStmtDto

    private val IlCallStmtDto = structdef {
        field("call", IlCallDto)
    } extends IlStmtDto

    private val IlReturnStmtDto = structdef {
        field("retVal", IlExprDto.nullable)
    } extends IlStmtDto

    private val IlEhStmtDto = structdef {

    } extends IlStmtDto

    private val IlBranchStmtDto = basestruct extends IlStmtDto

    private val IlGotoStmtDto = structdef {
        field("target", PredefinedType.int)
    } extends IlBranchStmtDto

    private val IlIfStmtDto = structdef {
        field("target", PredefinedType.int)
        field("cond", IlExprDto)
    } extends IlBranchStmtDto
    private val IlVarKind = enum {
        const("local", PredefinedType.int, 0)
        const("temp", PredefinedType.int, 1)
        const("err", PredefinedType.int, 2)
    }
    private val IlArgAccessDto = structdef {
        field("index", PredefinedType.int)
    } extends IlExprDto
    private val IlVarAccessDto = structdef {
        field("kind", IlVarKind)
        field("index", PredefinedType.int)
    } extends IlExprDto
}

object IlSigModel : Ext(IlModel) {
    private val request = structdef {
        field("rootAsm", PredefinedType.string)
    }

    init {
        signal("asmRequest", request).apply { async }
        signal("asmResponse", immutableList(IlModel.IlDto)).apply { async }
    }
}