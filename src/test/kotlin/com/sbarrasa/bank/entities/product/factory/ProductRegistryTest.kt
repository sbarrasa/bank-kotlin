package com.sbarrasa.bank.entities.product.factory

import com.sbarrasa.bank.entities.product.Product
import com.sbarrasa.bank.entities.product.types.*
import kotlin.test.*

class ProductRegistryTest{
    @BeforeTest
    fun init(){
        ProductRegistry
            .register(SavingAccount)
            .register(CheckingAccount)
            .register(CreditCard)
            .register(DebitCard)
    }

    @Test
    fun unknownProductType() {
        assertFailsWith<ProductTypeNotRegistered>{ ProductRegistry.create<Product>("HOLA")}
    }

    @Test
    fun invalidCastProductType() {
        assertFailsWith<ClassCastException> {
            val product: SavingAccount = ProductRegistry.create("TC")
            assertTrue(product.isCreditProduct)
        }

    }

    @Test
    fun createSavingAccount() {
        val product = ProductRegistry.create<SavingAccount>("CC")
        assertEquals("CC", product.id)
    }

    @Test
    fun asMap() {
        println(ProductRegistry.asMap())
    }
}