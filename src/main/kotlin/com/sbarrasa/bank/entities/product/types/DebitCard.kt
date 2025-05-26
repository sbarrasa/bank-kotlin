package com.sbarrasa.bank.entities.product.types

import com.sbarrasa.bank.entities.product.factory.ProductRegister

class DebitCard: Card(DebitCard) {
    companion object: ProductRegister<DebitCard> {
        override var id = "TD"
        override val description = "Tarjeta de débito"
        override val creator = ::DebitCard
    }
}