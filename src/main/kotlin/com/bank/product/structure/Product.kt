package com.bank.product.structure

import kotlinx.serialization.Serializable

@Serializable
abstract class Product {
   abstract val type: ProductDescriptor

   val isCredit get() = this is CreditProduct
   abstract fun fullDescription(): String
}