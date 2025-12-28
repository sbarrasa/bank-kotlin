package com.bank.model.products

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
@JsonClassDiscriminator("type")
sealed interface Product {
   val description: String

   val descriptor get() = ProductDescriptor[this::class]
}
