package com.sbarrasa.domain.person

import kotlinx.serialization.Serializable


@Serializable
@JvmInline
value class LastNames(override val value: String) : Names {
   init {
      Names.validate(value)
   }

   override fun toString() = value
   fun plus(other: GivenNames) = FullName(names = other, lastNames = this)

}