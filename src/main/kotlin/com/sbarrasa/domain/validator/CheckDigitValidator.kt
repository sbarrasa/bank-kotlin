package com.sbarrasa.domain.validator

import com.sbarrasa.domain.LegalIdException

abstract class CheckDigitValidator(val name: String) {

   abstract fun compute(digits: List<Int>): Int

   fun splitDigits(fullNumber: String): Pair<List<Int>, Int> {
      val digits = fullNumber.dropLast(1).map { it.digitToInt() }
      val check = fullNumber.last().digitToInt()
      return digits to check
   }

   fun compute(digits: String): Int {
      return compute(digits.map { it.digitToInt() })
   }

   fun validate(fullNumber: String) {
      val (digits, vd) = splitDigits(fullNumber)
      validate(digits, vd)
   }

   fun validate(digits: List<Int>, vd: Int) {
      val expected = compute(digits)
      if (expected != vd) throw LegalIdException("${msg.INVALID_CHECK_DIGIT} ($name)")
   }

   object msg {
      var INVALID_CHECK_DIGIT = "Dígito verificador inválido"
   }
}