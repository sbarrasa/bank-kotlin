package com.sbarrasa.bank.entities.product.types

import com.sbarrasa.bank.entities.product.Branch
import com.sbarrasa.bank.entities.product.Product
import com.sbarrasa.bank.entities.product.ProductHeader
import java.time.LocalDate

abstract class Card(header: ProductHeader): Product(header) {
    var branch: Branch? = null
    var number: String? = null
    var expirationDate: LocalDate? = null
    override fun fullDescription() = "${super.description} ${branch?.description}"
}