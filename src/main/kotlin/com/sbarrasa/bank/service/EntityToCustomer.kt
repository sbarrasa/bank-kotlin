package com.sbarrasa.bank.service

import com.sbarrasa.bank.model.customer.Customer
import com.sbarrasa.bank.repository.CustomerEntity
import com.sbarrasa.util.ObjectMapper

object EntityToCustomer: ObjectMapper<CustomerEntity, Customer>({
    bindAll(CustomerEntity::class, Customer::class)
    bind({it.id.value}, Customer::id)
})