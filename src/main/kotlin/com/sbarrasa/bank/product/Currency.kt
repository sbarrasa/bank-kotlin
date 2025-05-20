package com.sbarrasa.bank.product

import com.sbarrasa.util.id.EnumIdDesc
import com.sbarrasa.util.id.IdDesc

enum class Currency(override val description: String): IdDesc<String> {
    ARS("pesos"),
    USD("dólares"),
    EUR("euros");

    override val id = name
    companion object: EnumIdDesc<Currency> {
        override val values = entries
    }
}
