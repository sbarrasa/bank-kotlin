package com.sbarrasa.bank.product.types

import com.sbarrasa.bank.product.factory.ProductRegister

class DebitCard: Card(DebitCard) {
    companion object: ProductRegister<DebitCard> {
        override val id = "TD"
        override val description = "Tarjeta de débito"
        override val creator = ::DebitCard
    }
}