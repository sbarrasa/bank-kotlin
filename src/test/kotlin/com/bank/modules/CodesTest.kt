package com.bank.modules

import com.bank.model.product.factory.ProductFactory
import kotlin.test.*

class CodesTest {
   @Test
   fun getEntries() {
      ProductFactory.init()
      CodesCatalog.entries.forEach {
         println(it.key)
         it.value.forEach { println("   $it")}
      }
   }
}