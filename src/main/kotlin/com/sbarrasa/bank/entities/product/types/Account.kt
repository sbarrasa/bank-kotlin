package com.sbarrasa.bank.entities.product.types

import com.sbarrasa.bank.entities.product.Currency
import com.sbarrasa.bank.entities.product.Product
import com.sbarrasa.bank.entities.product.ProductHeader

abstract class Account(header: ProductHeader): Product(header) {
    var cbu: String? = null
    var currency: Currency? = null
    override fun fullDescription() = "${super.description} en ${currency?.description}"
}