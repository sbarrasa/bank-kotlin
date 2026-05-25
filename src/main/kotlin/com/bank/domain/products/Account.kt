package com.bank.domain.products

import com.swelms.domain.id.cbu.CBU
import com.swelms.domain.locale.Currency

sealed interface Account: Product {
   val cbu: CBU
   val currency: Currency

   override val description: String
      get() = "${descriptor.description } en ${currency.description}"

}