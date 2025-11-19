package com.bank.services

import com.bank.model.customer.Gender
import com.bank.model.products.structure.Currency
import com.sbarrasa.idlegal.cuit.CuitEntityCodes
import com.sbarrasa.id.map.Catalog
import com.sbarrasa.case.Case
import com.sbarrasa.idlegal.cuit.Cuit


//TODO: transformar en MemRepository
object CodesCatalog: Catalog(Case.SNAKE) {
   init {
      put(Cuit.EntityType::class)
      put(CuitEntityCodes)
      put(ProductTypes)
      put(Gender::class)
   //TODO: hacer adapters asMap   put(CardBrand::class)
      put(Currency::class)
   }
}

