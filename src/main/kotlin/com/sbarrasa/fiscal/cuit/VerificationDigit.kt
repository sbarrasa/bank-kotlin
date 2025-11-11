package com.sbarrasa.fiscal.cuit

import com.sbarrasa.fiscal.FiscalException

object VerificationDigit {
   private val weights = listOf(5, 4, 3, 2, 7, 6, 5, 4, 3, 2)
   fun compute(digits: String): Int {
      val sum = digits.mapIndexed { i, c -> c.digitToInt() * weights[i] }.sum()
      val mod = sum % 11
      return when (mod) {
         0 -> 0
         1 -> 9
         else -> 11 - mod
      }
   }


   fun validate(digits: String, vd: Int) {
      val expected = compute(digits)
      if (expected != vd)
         throw FiscalException("Verification digit mismatch. Expected $expected.")
   }

   fun validate(digits: String) {
      val base = digits.substring(0, 10)
      val vd = digits.last()
      validate(base, vd.digitToInt())
   }


}