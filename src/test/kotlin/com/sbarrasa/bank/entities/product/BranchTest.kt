package com.sbarrasa.bank.entities.product

import kotlin.test.*

class BranchTest {

    @Test
    fun asMap() {
        println(Branch.asMap())
    }

    @Test
    fun descAmex(){
        assertEquals("American Express", Branch.AMEX.description)
    }
}