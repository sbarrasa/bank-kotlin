package com.sbarrasa.dommain.person

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import com.sbarrasa.domain.person.LegalName
import kotlin.test.assertContains
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

class LegalNameTest {

   private val fullLegal = "Barrasa Rabinovich, Sebastián Gabriel"
   private val noComma = "Sebastián Gabriel Barrasa Rabinovich"

   @Test
   fun clean() {
      assertEquals(fullLegal,
         LegalName.clean(" Barrasa  *  Rabinovich, Sebastián 1234 Gabriel "))
   }

   @Test
   fun isValid() {
      assertTrue(LegalName.isValid(fullLegal))
   }

   @Test
   fun invalid(){
      val e = assertFailsWith<IllegalArgumentException> { LegalName("12345") }


      assertContains( e.message?:"", LegalName.msg.LAST_NAMES)
      assertContains( e.message?:"", LegalName.msg.NAMES)
   }

   @Test
   fun notIsValid() {
      assertFalse(LegalName.isValid(" Sebastián Gabriel "))
      assertFalse(LegalName.isValid("Barrasa,, Sebastián"))
      assertFalse(LegalName.isValid("Barrasa1, Sebastián"))
   }

   @Test
   fun parts() {
      val parts = LegalName.parts(fullLegal)
      assertEquals("Sebastián Gabriel", parts.names)
      assertEquals("Barrasa Rabinovich", parts.lastNames)
   }

   @Test
   fun partsWithoutComma() {
      val parts = LegalName.parts(noComma)
      assertEquals(noComma, parts.names)
      assertNull(parts.lastNames)
   }

   @Test
   fun names() {
      val n = LegalName(fullLegal)
      assertEquals("Sebastián Gabriel", n.names)
      assertEquals("Barrasa Rabinovich", n.lastNames)
   }

   @Test
   fun nameList() {
      val n = LegalName(fullLegal)
      assertEquals(listOf("Sebastián", "Gabriel"), n.nameList)
      assertEquals(listOf("Barrasa", "Rabinovich"), n.lastNameList)
   }

   @Test
   fun fullNameList() {
      val n = LegalName(fullLegal)
      assertEquals(listOf("Sebastián", "Gabriel", "Barrasa", "Rabinovich"),
         n.fullNameList)
   }

   @Test
   fun get() {
      val fullName = LegalName(fullLegal)
      assertEquals("Sebastián", fullName[0])
      assertEquals("Barrasa", fullName[2])
   }

   @Test
   fun size() {
      val n = LegalName(fullLegal)
      assertEquals(4, n.size)
   }

   @Test
   fun fullNameFormat() {
      val n = LegalName(fullLegal)
      assertEquals("Sebastián Gabriel Barrasa Rabinovich", n.fullNameFormat())
   }

   @Test
   fun toStringTest() {
      val n = LegalName(fullLegal)
      assertEquals(fullLegal, n.toString())
   }

   @Test
   fun legalNameFormat(){
      val n = LegalName(fullLegal)
      assertEquals(fullLegal, n.legalNameFormat())
   }

}
