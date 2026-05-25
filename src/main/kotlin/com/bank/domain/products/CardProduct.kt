package com.bank.domain.products

import com.swelms.domain.id.card.CardNumber
import kotlinx.datetime.LocalDate

sealed interface CardProduct : Product {
   val cardNumber: CardNumber
   val expirationDate: LocalDate

   override val description: String
      get() =  "${descriptor.description} ${cardNumber.brand?.description}"

}