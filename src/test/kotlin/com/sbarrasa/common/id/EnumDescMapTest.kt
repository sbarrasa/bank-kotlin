package com.sbarrasa.common.id

import kotlin.test.Test
import kotlin.test.assertEquals


class EnumDescMapTest {
   enum class EnumTest(override val description: String) : Desc {
      T1("test1"),
      T2("test2"),
      T3("test3");
   }

   val enumTestMap = EnumDescMappeable(EnumTest::class)

   @Test
   fun testEnumDescMapValues() {
      val key = EnumTest.T1
      assertEquals(
         key.description, enumTestMap.asMap().get(key)
      )
   }

   @Test
   fun testEnumDescMapSize() {
      assertEquals(EnumTest.entries.size, enumTestMap.asMap().size)
   }

   @Test
   fun testEnumDescMapKeys() {
      assertEquals(EnumTest.entries.toSet(), enumTestMap.asMap().keys)
   }

}






