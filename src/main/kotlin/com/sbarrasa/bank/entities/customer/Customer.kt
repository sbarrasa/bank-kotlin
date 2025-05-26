package com.sbarrasa.bank.entities.customer

import com.sbarrasa.util.id.Id
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Customer (
    override var id: Int? = null,
    var name: String,
    var lastName: String,
    var birthDay: LocalDate,
    var gender: Gender
) : Id<Int?>
