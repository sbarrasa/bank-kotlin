package com.sbarrasa.util.cuit

import com.sbarrasa.cuit.Cuit
import com.sbarrasa.cuit.EntityType
import com.sbarrasa.cuit.FiscalException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CuitTest {

   @Test
   fun validString() {
      val cuit = Cuit("20240614708")
      assertEquals("20", cuit.entityCode)
      assertEquals("24061470", cuit.document)
      assertEquals("8", cuit.vd)
      assertEquals("20240614708", cuit.toString())
   }

   @Test
   fun invalidString() {
      assertFailsWith<FiscalException> {
         Cuit("123456789")
      }
   }

   @Test
   fun validOf() {
      val cuit = Cuit.of("20", "24061470", "8")
      assertEquals("20240614708", cuit.value)
   }

   @Test
   fun invalidOf() {
      assertFailsWith<FiscalException> {
         Cuit.of("20", "2024061470", "1")
      }
   }

   @Test
   fun padding() {
      val cuit = Cuit.of("20", "123456", "1")
      assertEquals("20001234561", cuit.value)
   }

   @Test
   fun nonNumeric() {
      assertFailsWith<FiscalException> {
         Cuit.of("2A", "32964B33", "C")
      }
   }

   @Test
   fun entityType() {
      val cuit = Cuit("20240614708")
      assertEquals(cuit.entityType, EntityType.FISICA)
   }

   @Test
   fun entityCodeFail() {
      assertFailsWith<FiscalException> {
         Cuit.of("10", "24061470", "8")
      }
   }


}