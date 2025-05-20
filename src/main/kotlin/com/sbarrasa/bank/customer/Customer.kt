package com.sbarrasa.bank.customer

import com.sbarrasa.util.id.Id
import kotlinx.datetime.LocalDate

data class Customer(
    override val id: Int,
    val name: String,
    val lastName: String,
    val birthDay: LocalDate
        ) : Id<Int> {
}