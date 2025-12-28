package com.bank.services

import com.bank.model.products.ProductDescriptor
import com.bank.model.products.activeCurrencies
import com.swelms.domain.person.Gender
import com.swelms.common.collections.*
import com.swelms.common.enums.*
import com.swelms.common.text.Style
import com.swelms.domain.id.card.CardBrand
import com.swelms.domain.id.cuit.*
import kotlin.collections.associate


object Codes: Catalog(Style.SNAKE) {
   init {
      init()
   }
   fun init(){
      put("Cuit.EntityType", Cuit.EntityType.entries.associateWith { it.description})
      put("Cuit.EntityCodes", Cuit.EntityCodes.associate { it.key to it.description })
      put("Products", ProductDescriptor.idMap)
      put(Gender.entries.associateWith { it.description })
      put(CardBrand.entries.associateWith { it.description})
      put(activeCurrencies.associateWith{ it.localeDescription})
   }
}

