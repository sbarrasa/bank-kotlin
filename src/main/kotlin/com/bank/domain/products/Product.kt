package com.bank.domain.products

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
@JsonClassDiscriminator("type")
sealed interface Product {
   val description: String

   val descriptor get() = ProductDescriptor[this::class]
}
