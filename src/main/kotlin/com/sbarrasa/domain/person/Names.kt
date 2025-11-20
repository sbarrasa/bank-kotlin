package com.sbarrasa.domain.person

import kotlin.text.split

interface Names {
   val text: String

   val list:List<String> get() = text.split(" ")
   val count: Int get() = list.size

   operator fun get(index: Int) = list[index-1]

   companion object {
      fun clean(text: String): String {
         return text.replace(Regex("[^\\p{L} ]"), "")
            .trim()
            .replace(Regex("\\s+"), " ")
      }
      fun validate(text: String) = require(isValid(text)) { texts.INVALID_FORMAT }

      fun isValid(text: String): Boolean {
         return text == clean(text)
      }

      fun from(
         fullNameText: String,
         cleanInput: Boolean = false
      ): Names {
         val parts = fullNameText.split(",")
         if (parts.size != 2) throw IllegalArgumentException(texts.INVALID_FORMAT)

         val last  = parts[0].trim()
         val given = parts[1].trim()
         return from(last, given, cleanInput)
      }

      fun from(
         lastNamesText: String? = null,
         givenNamesText: String? = null,
         cleanInput: Boolean = false
      ): Names {
         val last  = lastNamesText  ?.let { if (cleanInput) clean(it) else it }
         val given = givenNamesText ?.let { if (cleanInput) clean(it) else it }

         return when {
            given != null && last != null -> FullName(NamePart(last), NamePart(given))
            given != null -> NamePart(given)
            last  != null -> NamePart(last)
            else -> throw IllegalArgumentException(texts.ONE_NAME_REQUIRED)
         }
      }


   }

   object texts {
      var ONE_NAME_REQUIRED = "Debe incluir al menos un nombre"
      var INVALID_FORMAT = "Los nombres no pueden incluir caracteres especiales"
   }
}