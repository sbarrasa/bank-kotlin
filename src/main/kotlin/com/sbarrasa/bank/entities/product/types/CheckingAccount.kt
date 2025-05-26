package com.sbarrasa.bank.entities.product.types

import com.sbarrasa.bank.entities.product.factory.ProductRegister

class CheckingAccount : Account(CheckingAccount) {
    companion object : ProductRegister<CheckingAccount> {
        override var id = "CA"
        override val description = "Caja de ahorro"
        override val creator = ::CheckingAccount
    }
}