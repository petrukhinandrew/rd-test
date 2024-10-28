package org.example.ilinstances

import com.jetbrains.rider.model.IlAsmDto

class IlAsm(private val dto: IlAsmDto) : IlInstance {
    val location = dto.location
    val types: MutableList<IlType> = mutableListOf()

    override fun attach() {}
}
