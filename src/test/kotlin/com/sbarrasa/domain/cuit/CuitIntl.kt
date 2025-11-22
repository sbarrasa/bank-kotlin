package com.sbarrasa.domain.cuit

import kotlin.test.Test

class CuitIntl {
   init{
      Cuit.Texts.PERSON_DESCRIPTION = "individual"
      Cuit.Texts.COMPANY_DESCRIPTION = "company"
      Cuit.Texts.CUIT_CUIL = "CUIT/CUIL"
      Cuit.Texts.INVALID_LENGTH = "CUIT must have 11 numeric digits"
      Cuit.Texts.ONLY_DIGITS = "CUIT can contain only numbers"
      Cuit.Texts.INVALID_ENTITY_CODE = "Invalid entity code"
   }

   @Test
   fun showEnglishTextsDirect() {

      // Mostrar en pantalla
      println("PERSON_DESCRIPTION: ${Cuit.Texts.PERSON_DESCRIPTION}")
      println("COMPANY_DESCRIPTION: ${Cuit.Texts.COMPANY_DESCRIPTION}")
      println("CUIT_CUIL: ${Cuit.Texts.CUIT_CUIL}")
      println("INVALID_LENGTH: ${Cuit.Texts.INVALID_LENGTH}")
      println("ONLY_DIGITS: ${Cuit.Texts.ONLY_DIGITS}")
      println("INVALID_ENTITY_CODE: ${Cuit.Texts.INVALID_ENTITY_CODE}")
   }
}