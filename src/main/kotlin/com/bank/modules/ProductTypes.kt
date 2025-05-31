package com.bank.modules

import com.bank.model.product.factory.ProductTypes
import com.bank.model.product.types.*

fun ProductTypes.init(){
   register(SavingAccount)
   register(CheckingAccount)
   register(CreditCard)
   register(DebitCard)
}