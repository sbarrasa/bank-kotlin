package com.sbarrasa.bank.product

import com.sbarrasa.util.id.EnumIdDesc
import com.sbarrasa.util.id.IdDesc

enum class Branch(override val description: String): IdDesc<String>{
    VISA("VISA"),
    MC("MasterCard"),
    AMEX("American Express");

    override val id = name
    companion object : EnumIdDesc<Branch> {
        override val values = entries
    }
}
