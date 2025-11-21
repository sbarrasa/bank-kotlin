package com.bank.model.products.structure

import com.sbarrasa.domain.cbu.CBU
import kotlinx.serialization.Serializable

@Serializable
abstract class Account: Product() {
   abstract val cbu: CBU
   abstract val currency: Currency

   override val description: String
      get() = "${descriptor?.description} en ${currency.description}"

}