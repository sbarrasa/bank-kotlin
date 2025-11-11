package com.bank.modules

import com.bank.model.customer.Gender
import com.bank.model.product.Branch
import com.bank.model.product.Currency
import com.bank.model.product.factory.ProductFactory
import com.sbarrasa.fiscal.cuit.EntityCodes
import com.sbarrasa.fiscal.cuit.EntityType
import com.sbarrasa.util.map.Catalog
import com.sbarrasa.util.case.Case


object CodesCatalog: Catalog(Case.SNAKE) {
   init {
      put(EntityType::class)
      put(EntityCodes)
      put(ProductFactory)
      put(Gender::class)
      put(Branch::class)
      put(Currency::class)
   }
}

