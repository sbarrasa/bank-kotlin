package com.sbarrasa.bank.entities.customer

import com.sbarrasa.util.ObjectMapper

object CustomerMapper: ObjectMapper<Customer, Customer>({
    bindAll(Customer::class, Customer::class)
})