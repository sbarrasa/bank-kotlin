package com.bank.product.structure

import kotlinx.serialization.Serializable

@Serializable
abstract class Product: ProductDescriptor {
   abstract val descriptor: ProductDescriptor

   override val id get() = descriptor.id

   override val description get() = descriptor.description

   val isCreditProduct get() = this is CreditProduct
   abstract fun fullDescription(): String
}