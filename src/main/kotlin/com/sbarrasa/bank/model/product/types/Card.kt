package com.sbarrasa.bank.model.product.types

import com.sbarrasa.bank.model.product.Branch
import com.sbarrasa.bank.model.product.Product
import com.sbarrasa.bank.model.product.ProductHeader
import java.time.LocalDate

abstract class Card(header: ProductHeader): Product(header) {
    var branch: Branch? = null
    var number: String? = null
    var expirationDate: LocalDate? = null
    override fun fullDescription() = "${super.description} ${branch?.description}"
}