package com.sbarrasa.domain.person

import kotlinx.serialization.Serializable

@Serializable
data class NameParts(val names: String, val lastNames: String?=null)
