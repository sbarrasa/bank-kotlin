package com.bank.model.customer

import com.sbarrasa.person.Name
import kotlinx.datetime.LocalDate
import java.time.Month
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerTest {
   val customer1 = Customer(
      id = 1,
      fullName = Name("Sebastian Gabriel", "Barrasa"),
      birthDay = LocalDate(1974, Month.JUNE, 7),
      gender = Gender.M
   )

   @Test
   fun birthDayTest() {
      assertEquals(Month.JUNE, customer1.birthDay!!.month)
   }

   @Test
   fun namesTest(){
      assertEquals("Sebastian", customer1.firstName)
      assertEquals("Barrasa", customer1.lastName)
      assertEquals(2, customer1.names.size)
      assertEquals("Sebastian Gabriel Barrasa", customer1.fullName())

   }
}