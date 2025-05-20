package com.sbarrasa.bank.product

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BranchTest {

    @Test
    fun asMap() {
        println(Branch.asMap())
    }

    @Test
    fun idVISA() {
        assertEquals("VISA", Branch.VISA.id)
    }

    @Test
    fun descAmex(){
        assertEquals("American Express", Branch.AMEX.description)
    }
}