package com.bank.domain.customer

import com.bank.domain.products.Product
import kotlinx.serialization.Serializable

@Serializable
data class CustomerProducts(
   val customer: Customer,
   val products: List<Product> = mutableListOf()
)