package com.sbarrasa.domain.person

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class LegalName(override val text: String) : Names, FullNameInterface  {
   init {
      NameUtils.validate(text, isLegalName=true)
   }

   private val parts get() = NameUtils.simpleFullName(text)

   override val lastNames get() = parts.lastNames
   override val givenNames get() = parts.givenNames

   override val list: List<String> get() = givenNames.list + lastNames.list
}
