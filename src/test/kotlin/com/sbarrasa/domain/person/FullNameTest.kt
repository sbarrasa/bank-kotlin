package com.sbarrasa.domain.person

import kotlin.test.*

class FullNameTest {

   @Test
   fun fullNameParts() {
      val legalName = LegalName("Garcia, Jose Maria")
      assertEquals("Jose Maria", legalName.givenNames.text)
      assertEquals("Garcia", legalName.lastNames.text)
      assertEquals(listOf("Jose", "Maria", "Garcia"), legalName.list)
   }


   @Test
   fun fullNameInvalidFormat() {
      assertFailsWith<IllegalArgumentException> {
         LegalName("SoloNombre")
      }
      assertFailsWith<IllegalArgumentException> {
         LegalName("Apellido1, Apellido2, Nombre")
      }
   }
}
