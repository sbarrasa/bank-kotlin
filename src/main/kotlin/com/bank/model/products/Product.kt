package com.bank.model.products

import kotlinx.serialization.Serializable

@Serializable
sealed interface Product {
   val description: String

   val descriptor get() = ProductDescriptor[this::class]
}
