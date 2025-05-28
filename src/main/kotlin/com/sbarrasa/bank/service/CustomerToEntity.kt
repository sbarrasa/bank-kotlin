package com.sbarrasa.bank.service

import com.sbarrasa.bank.model.customer.Customer
import com.sbarrasa.bank.repository.CustomerEntity
import com.sbarrasa.util.ObjectMapper

object CustomerToEntity: ObjectMapper<Customer, CustomerEntity>({
    bindAll(Customer::class, CustomerEntity::class)
})