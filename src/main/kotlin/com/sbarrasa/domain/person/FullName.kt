package com.sbarrasa.domain.person

import kotlinx.serialization.Serializable

@Serializable
data class FullName(val names: GivenNames,
                    val lastNames: LastNames?): NamesList{

   override val list get() = names.list + (lastNames?.list ?: emptyList())

   override fun toString(): String {
      return "$lastNames, $names"
   }

}
