package org.example.ilinstances

import com.jetbrains.rider.model.IlMethodDto
import com.jetbrains.rider.model.IlParameterDto

class IlMethod(private val dto: IlMethodDto) : IlInstance {
    var declType: IlType? = null
    var returnType: IlType? = null
    val name: String = dto.name
    val parametes: MutableList<IlParameter> = dto.parameters.map { IlParameter(it) }.toMutableList()

    override fun attach() {
        if (dto.declType != null) {
            declType = IlInstance.cache.getType(dto.declType)
            (declType as IlType).methods.add(this)
        }
        if (dto.returnType != null)
            returnType = IlInstance.cache.getType(dto.returnType)
        parametes.forEach { it.attach() }
    }
}

class IlParameter(private val dto: IlParameterDto) : IlInstance {
    lateinit var paramType: IlType
    val name: String = dto.name
    override fun attach() {
        paramType = IlInstance.cache.getType(dto.type)
    }

}