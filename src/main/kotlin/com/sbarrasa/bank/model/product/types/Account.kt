package com.sbarrasa.bank.model.product.types

import com.sbarrasa.bank.model.product.Currency
import com.sbarrasa.bank.model.product.Product
import com.sbarrasa.bank.model.product.ProductHeader

abstract class Account(header: ProductHeader): Product(header) {
    var cbu: String? = null
    var currency: Currency? = null
    override fun fullDescription() = "${super.description} en ${currency?.description}"
}