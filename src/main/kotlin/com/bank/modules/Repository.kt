package com.bank.modules

import com.bank.repository.CustomerRepository
import com.bank.repository.ExposedCustomerRepository
import com.bank.repository.MemCustomerRepository

object Repository {
    enum class Types {
        MEM, EXPOSED
    }

    const val paramKey = "repo"

    var type: Types = Types.MEM

    val get: CustomerRepository
        get() = when(type) {
            Types.MEM -> MemCustomerRepository()
            Types.EXPOSED -> {
                DBClient.init()
                ExposedCustomerRepository()
            }
        }


    fun set(typeStr: String?) {
        type = Types.valueOf(typeStr?:"MEM")
    }
}