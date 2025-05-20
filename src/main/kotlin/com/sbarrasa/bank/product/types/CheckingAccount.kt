package com.sbarrasa.bank.product.types

import com.sbarrasa.bank.product.factory.ProductRegister

class CheckingAccount : Account(CheckingAccount) {
    companion object : ProductRegister<CheckingAccount> {
        override val id = "CA"
        override val description = "Caja de ahorro"
        override val creator = ::CheckingAccount
    }
}