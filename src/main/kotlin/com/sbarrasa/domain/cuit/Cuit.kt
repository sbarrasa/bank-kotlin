package com.sbarrasa.domain.cuit

import com.sbarrasa.common.id.Desc
import com.sbarrasa.domain.LegalIdException
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class Cuit(val value: String) {

   val entityCode: String get() = value.substring(0, 2)
   val document: String get() = value.substring(2, 10)
   val check: Char get() = value.substring(10, 11)[0]

   val entityType: EntityType? get() = CuitEntityCodes[entityCode]?.entityType

   init {
      validateLength()
      validateDigits()
      validateEntityCode()
      validateCheckDigit()
   }

   private fun validateLength() {
      if (value.length != SIZE) throw LegalIdException(msg.INVALID_LENGTH)
   }

   private fun validateDigits() {
      if (!value.all { it.isDigit() }) throw LegalIdException(msg.DIGITS)
   }

   private fun validateEntityCode() {
      if (!CuitEntityCodes.contains(entityCode)) throw LegalIdException(msg.INVALID_ENTITY_CODE)
   }

   private fun validateCheckDigit() {
      CuitCheckDigitValidator.validate(value)
   }

   object msg {
      var CUIT_CUIL = "CUIT/CUIL"
      var INVALID_LENGTH = "CUIT debe tener $SIZE dígitos numéricos"
      var DIGITS = "CUIT solo puede contener números"
      var INVALID_ENTITY_CODE = "Código de entidad inválido"
   }

   companion object {
      var SIZE = 11
   }

   fun formated() = "$entityCode-$document-$check"
   override fun toString(): String = value

   enum class EntityType(override val description: String) : Desc {
      PERSON("persona física"),
      COMPANY("persona juridica");
   }
}