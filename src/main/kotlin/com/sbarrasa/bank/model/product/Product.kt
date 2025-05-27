package com.sbarrasa.bank.model.product

import com.sbarrasa.bank.model.product.types.CreditProduct

abstract class Product(header: ProductHeader): ProductHeader by header {
    val isCreditProduct = (this is CreditProduct)
    abstract fun fullDescription(): String
 }