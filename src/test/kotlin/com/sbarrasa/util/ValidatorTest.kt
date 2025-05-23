package com.sbarrasa.util

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class ValidatorTest {
    @Test
    fun validateString(){
        val result = "Hola mundo".validate(
            {this.isNotBlank() && this.length > 5}
        )

        assertTrue { result }
     }

    @Test
    fun validateInt(){
        val result = 10.validate({ this in 1..100 })
        assertTrue { result }

    }

    @Test
    fun validateWithException(){
        val validator = Validator<String>(
            predicate = { this.length > 5},
            exception = {IllegalArgumentException(it)}
        )

        val value  = "Hola"
        assertFailsWith<IllegalArgumentException> { validator.validate(value)}
    }

}