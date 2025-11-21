package com.bank.services

import kotlin.test.*

class CodesCatalogTest {
   @Test
   fun getEntries() {
      CodesCatalog.entries.forEach {
         println(it.key)
         it.value.forEach { println("   $it")}
      }
   }
}