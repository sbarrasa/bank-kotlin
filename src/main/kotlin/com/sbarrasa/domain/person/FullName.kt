package com.sbarrasa.domain.person

import kotlinx.serialization.Serializable

@Serializable
data class FullName(val lastNames: NamePart, val givenNames: NamePart): Names {

   override val text: String
      get() = "$lastNames, $givenNames"

   override val list get() = givenNames.list + lastNames.list

   override fun toString(): String = text


}
