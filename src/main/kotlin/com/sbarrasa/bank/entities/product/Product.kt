package com.sbarrasa.bank.entities.product

import com.sbarrasa.bank.entities.product.types.CreditProduct

abstract class Product(header: ProductHeader): ProductHeader by header {
    val isCreditProduct = (this is CreditProduct)
    abstract fun fullDescription(): String
 }