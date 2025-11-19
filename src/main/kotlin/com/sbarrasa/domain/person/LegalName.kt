package com.sbarrasa.domain.person

import kotlinx.serialization.Serializable


@Serializable
@JvmInline
value class LegalName(val value: String){
   init {
      require(isValid(value)) { msg.INVAliD_FORMAT }
   }

   val nameList get() = names.split(" ")
   val lastNameList get() = lastNames?.split(" ") ?: emptyList()

   val fullNameList get() = nameList + lastNameList

   val names get() = parts.names
   val lastNames get() = parts.lastNames

   val parts get() = parts(value)

   val size: Int get() = fullNameList.size

   operator fun get(index: Int) = fullNameList[index]

   fun legalNameFormat() = value

   fun fullNameFormat() = "$names $lastNames"

   override fun toString() = value

   companion object{
      fun parts(legalName: String): NameParts {
         return if (legalName.contains(",")) {
            val parts = legalName.split(",")
            NameParts(
               names = parts[1].trim(),
               lastNames = parts[0].trim()
            )
         } else {
            NameParts(names = legalName)
         }
      }
      private fun hasOneComma(value: String) = value.count { it == ',' } <= 1

      fun clean(value: String): String {
         val regex = Regex("[\\p{L} ,]")
         val filtered = value.filter { regex.matches(it.toString()) }.trim()
         return filtered.replace(Regex("\\s+"), " ")
      }

      fun isValid(value: String): Boolean {
         return hasOneComma(value) and (value == clean(value))
      }

   }
   object msg {
      var LAST_NAMES = "Apellidos"
      var NAMES = "Nombres"
      var INVAliD_FORMAT = "Formato legal de nombre inválido $LAST_NAMES, $NAMES"
   }

}