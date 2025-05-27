package com.sbarrasa.util.mapper

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1


class ObjectMapper<S, T>(
    init: ObjectMapper<S, T>.() -> Unit = {}
) {
    private val mappings = mutableListOf<Pair<KProperty1<S, Any?>, KMutableProperty1<T, Any?>>>()

    @Suppress("UNCHECKED_CAST")
    fun <V> bind(getter: KProperty1<S, V>, setter: KMutableProperty1<T, V>) {
        mappings += (getter as KProperty1<S, Any?>) to (setter as KMutableProperty1<T, Any?>)
    }

    fun map(source: S, target: T) {
        for ((getter, setter) in mappings) {
            val value = getter.get(source)
            if (value != null) {
                setter.set(target, value)
            }
        }
    }

    init {
        this.init()
    }
}