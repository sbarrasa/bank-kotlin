package com.bank.model.customer

import com.sbarrasa.domain.person.LegalName
import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerTest {

   val customer1 = Customer(
      id = 1,
      legalName = LegalName("Barrasa, Sebastián Gabriel"),
      birthDay = LocalDate(1974, Month.JUNE, 7),
      gender = Gender.M
   )

   @Test
   fun jsonDeserializationTest() {
      val json = """
        {
            "id": 1,
            "legalName": "Barrasa, Sebastián Gabriel",
            "birthDay": "1974-06-07",
            "gender": "M"
        }
      """
      val customer = Json.decodeFromString<Customer>(json)
      assertEquals(customer1, customer)
   }
   @Test
   fun birthDayTest() {
      assertEquals(Month.JUNE, customer1.birthDay!!.month)
   }

}