package org.example.ilinstances

interface IlInstance {
    fun attach()

    companion object {
        val cache = IlCache()
    }
}