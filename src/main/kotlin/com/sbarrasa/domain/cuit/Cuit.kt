package com.sbarrasa.domain.cuit

import com.sbarrasa.common.id.Desc
import com.sbarrasa.domain.validator.ValidatorException
import com.sbarrasa.domain.validator.DigitsValidator
import com.sbarrasa.domain.validator.LengthValidator
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
      LengthValidator(texts.INVALID_LENGTH, SIZE).validate(value)
   }

   private fun validateDigits() {
      DigitsValidator(texts.ONLY_DIGITS).validate(value)
   }

   private fun validateEntityCode() {
      if (!CuitEntityCodes.contains(entityCode)) throw ValidatorException(texts.INVALID_ENTITY_CODE)
   }

   private fun validateCheckDigit() {
      CuitCheckDigitValidator.validate(value)
   }

   companion object {
      const val SIZE = 11
   }

   fun formated() = "$entityCode-$document-$check"
   override fun toString(): String = value

   enum class EntityType(override val description: String) : Desc {
      PERSON(texts.PERSON_DESCRIPTION),
      COMPANY(texts.COMPANY_DESCRIPTION);
   }

   object texts {
      var PERSON_DESCRIPTION = "persona física"
      var COMPANY_DESCRIPTION = "persona juridica"
      var CUIT_CUIL = "CUIT/CUIL"
      var INVALID_LENGTH = "CUIT debe tener $SIZE dígitos numéricos"
      var ONLY_DIGITS = "CUIT solo puede contener números"
      var INVALID_ENTITY_CODE = "Código de entidad inválido"
   }

}