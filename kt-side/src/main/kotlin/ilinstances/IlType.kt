package org.example.ilinstances

import com.jetbrains.rider.model.AsmCacheKey
import com.jetbrains.rider.model.IlTypeDto

class IlType(private val dto: IlTypeDto) : IlInstance {
    lateinit var declAsm: IlAsm
    val name: String = dto.name
    val fields: MutableList<IlField> = mutableListOf()
    val methods: MutableList<IlMethod> = mutableListOf()
    override fun attach() {
        declAsm = IlInstance.cache.getAsm(AsmCacheKey(dto.id.asm))
        declAsm.types.add(this)
    }
}