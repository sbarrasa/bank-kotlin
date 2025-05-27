package com.sbarrasa.bank.module

import com.sbarrasa.bank.controller.CustomerController
import com.sbarrasa.bank.repository.customer.ExposedCustomerRepository
import com.sbarrasa.bank.service.CustomerService

object CustomerModule {
    private val repository = ExposedCustomerRepository() // MemCustomerRepository()
    private val service = CustomerService(repository)
    val controller = CustomerController(service)

}