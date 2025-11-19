package com.sbarrasa.domain.person

interface Names: NamesList {
   val value: String

   override val list get() = value.split(" ")
   companion object {
      fun clean(value: String): String {
         return value.replace(Regex("[^\\p{L} ]"), "")
            .trim()
            .replace(Regex("\\s+"), " ")
      }
      fun validate(value: String) = require(isValid(value)) { msg.INVALID_FORMAT }

      fun isValid(value: String): Boolean {
         return value == clean(value)
      }

      fun given(givenNames: String) = GivenNames(givenNames)
      fun last(lastNames: String) = LastNames(lastNames)
      fun full(givenNames: String, lastNames: String? = null)
                                 = FullName(GivenNames(givenNames),
                                    lastNames?.let { LastNames(it) })

   }

   object msg {
      var INVALID_FORMAT = "Los nombres no pueden incluir caracteres especiales"
   }
}