package com.bank.domain.products

sealed interface CreditProduct {
   val creditLimit: Double
}