@file:Suppress("unused")

package org.example.model

import com.jetbrains.rd.generator.nova.*
import com.jetbrains.rd.generator.nova.csharp.CSharp50Generator
import com.jetbrains.rd.generator.nova.kotlin.Kotlin11Generator
import com.jetbrains.rd.generator.paths.csDirectorySystemPropertyKey
import com.jetbrains.rd.generator.paths.ktDirectorySystemPropertyKey
import com.jetbrains.rd.generator.paths.outputDirectory

const val folder = "Il"

object IlRoot : Root(
    Kotlin11Generator(FlowTransform.AsIs, "Il", outputDirectory(ktDirectorySystemPropertyKey, folder)),
    CSharp50Generator(FlowTransform.Reversed, "Il", outputDirectory(csDirectorySystemPropertyKey, folder))
)


object IlModel : Ext(IlRoot) {

    private val cacheKey = structdef {
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

    private val IlMethodDto = structdef {
        field("id", cacheKey)
        field("declType", cacheKey)
        field("returnType", cacheKey)
        field("name", PredefinedType.string)
        field("parameters", immutableList(IlParameterDto))
    } extends IlDto
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