package com.sbarrasa.domain.person

import kotlin.test.*

class NamesTest {

   @Test fun clean_ok() {
      assertEquals("Juan Perez", Names.clean(" Juan!!   Perez "))
   }

   @Test fun isValid_true() {
      assertTrue(Names.isValid("Juan Perez"))
   }

   @Test fun isValid_false() {
      assertFalse(Names.isValid("Juan!! Perez"))
   }

   @Test fun validate_ok() {
      Names.validate("Juan Perez")
   }

   @Test fun validate_fail() {
      assertFailsWith<IllegalArgumentException> { Names.validate("Juan!! Perez") }
   }

   @Test fun from_full_ok() {
      val n = Names.from("Perez Alonso, Juan José") as FullName
      assertEquals("Perez Alonso", n.lastNames.text)
      assertEquals("Juan José", n.givenNames.text)
   }

   @Test fun from_full_fail() {
      assertFailsWith<IllegalArgumentException> { Names.from("Juan Perez") }
   }

   @Test fun from_given() {
      val n = Names.from(givenNamesText = "Juan") as NamePart
      assertEquals("Juan", n.text)
   }

   @Test fun from_last() {
      val n = Names.from(lastNamesText = "Perez")
      assertEquals("Perez", n.text)
   }

   @Test fun from_both() {
      val n = Names.from("Perez", "Juan") as FullName
      assertEquals("Perez", n.lastNames.text)
      assertEquals("Juan", n.givenNames.text)
   }

   @Test fun from_none() {
      assertFailsWith<IllegalArgumentException> { Names.from(null, null) }
   }

   @Test fun index_ok() {
      val n = Names.from(givenNamesText = "Juan Carlos")
      assertEquals("Juan", n[1])
      assertEquals("Carlos", n[2])
   }

   @Test fun count_ok() {
      val n = Names.from(givenNamesText = "Juan Carlos")
      assertEquals(2, n.count)
   }
}
