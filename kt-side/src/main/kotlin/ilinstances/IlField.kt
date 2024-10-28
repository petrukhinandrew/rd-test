package org.example.ilinstances

import com.jetbrains.rider.model.IlFieldDto

class IlField(private val dto: IlFieldDto) : IlInstance {
    lateinit var declType: IlType
    lateinit var fieldType: IlType
    val isStatic: Boolean = dto.isStatic
    val name: String = dto.name

    override fun attach() {
        declType = IlInstance.cache.getType(dto.declType)
        declType.fields.add(this)
        fieldType = IlInstance.cache.getType(dto.fieldType)

    }
}