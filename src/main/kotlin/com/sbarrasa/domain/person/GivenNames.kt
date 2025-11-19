package com.sbarrasa.domain.person

import kotlinx.serialization.Serializable


@Serializable
@JvmInline
value class GivenNames(override val value: String) : Names {
   init {
      Names.validate(value)
   }

   override fun toString() = value
   fun plus(other: LastNames) = FullName(names = this, lastNames = other)

}