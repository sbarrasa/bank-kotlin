package com.sbarrasa.cuit

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class Cuit(val value: String) {
   val entityCode: String get() = value.substring(0, 2)
   val document: String get() = value.substring(2, 10)
   val vd: String get() = value.substring(10, 11)

   val entityType: EntityType? get() = EntityCodes[entityCode]?.entityType

   init {
      validateDigits(value, 11, "CUIT")
      EntityCodes.validate(entityCode)
      VerificationDigit.validate(value)
   }

   companion object {
      fun of(entityType: String, document: String, vd: String): Cuit {
         val entityTypePaded = padPart(entityType, 2)
         val documentPaded = padPart(document, 8)

         validateDigits(entityTypePaded, 2, "entityType")
         validateDigits(documentPaded, 8, "document")
         validateDigits(vd, 1, "vd (verification digit)")

         return Cuit("$entityTypePaded$documentPaded$vd")
      }

      fun validateDigits(value: String, size: Int, id: String) {
         if (value.length != size
            || value.all { !it.isDigit() }
         ) throw FiscalException("$id must have $size numeric digits.")
      }

      fun padPart(value: String, size: Int): String {
         return value.padStart(size, '0')
      }
   }

   override fun toString() = value
}

