package com.sbarrasa.domain.card

import com.sbarrasa.domain.LegalIdException
import com.sbarrasa.domain.validator.LuhnValidator
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class CardNumber(val value: String) {
   init {
      validateLength()
      validateDigits()
      validateCheckDigit()
   }

   val brand: CardBrand? get() = CardBrand.of(this)

   private fun validateLength() {
      if (value.length !in BinTable.lengthRange()) throw LegalIdException(msg.LENGTH)
   }

   private fun validateDigits() {
      if (!value.all { it.isDigit() }) throw LegalIdException(msg.DIGITS)
   }

   private fun validateCheckDigit() {
      LuhnValidator.validate(value)
   }

   object msg {
      var CARD = "Número de tarjeta"
      var LENGTH = "Longitud de número de tarjeta inválido ($)"
      var DIGITS = "Número de tarjeta solo puede contener números"
   }

   companion object{
      fun from(cardNumber: String) = CardNumber(cardNumber.filter { it.isDigit() })
   }
   override fun toString(): String = value
}

