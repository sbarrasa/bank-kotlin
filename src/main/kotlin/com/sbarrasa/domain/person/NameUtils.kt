package com.sbarrasa.domain.person

object NameUtils {

   val validChars =  Regex("[^\\p{L}' ]")

   fun clean(text: String): String {
      return text.replace(validChars, "")
         .trim()
         .replace(Regex("\\s+"), " ")
   }

   fun validate(text: String, isLegalName: Boolean = false){
      if(isLegalName){
         val parts = split(text)
         validate(parts[0].trim(), isLegalName = false)
         validate(parts[1].trim(), isLegalName = false)
      } else {
         require(isValid(text)) { Texts.INVALID_FORMAT }
      }
   }

   fun isValid(text: String): Boolean {
      return text == clean(text)
   }

   fun split(fullNameText: String): List<String> {
      val parts = fullNameText.split(",")
      if (parts.size != 2) throw IllegalArgumentException(Texts.INVALID_FORMAT)
      return parts
   }
   fun simpleFullName(fullNameText: String): FullNameInterface {
      val parts = split(fullNameText)
      return object: FullNameInterface {
         override val givenNames: NamePart
            get() = NamePart(parts[1].trim())
         override val lastNames: NamePart
            get() = NamePart(parts[0].trim())
      }
   }

   object Texts {
      var INVALID_FORMAT = "Los nombres no pueden incluir caracteres especiales"
   }
}