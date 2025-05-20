package com.sbarrasa.util.id

interface EnumIdDesc<E> where E : Enum<E>, E : IdDesc<String> {
    val values: List<E>
    fun asMap(): Map<String, String> = values.associate { it.id to it.description }
}