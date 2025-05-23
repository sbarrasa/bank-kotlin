package com.sbarrasa.util

fun <T> T.validate(
    predicate: T.() -> Boolean,
    exception: ((T) -> Exception)? = null
): Boolean {
    val valid = predicate()
    if(!valid && exception != null)
        throw exception(this)
    return valid
}

class Validator<T>(
    val predicate: T.() -> Boolean,
    val exception: ((T) -> Exception)? = null
) {
    fun validate(obj: T): Boolean = obj.validate(predicate, exception)
}
