package com.sbarrasa.bank.config

import com.sbarrasa.bank.controller.CustomerController
import com.sbarrasa.bank.repository.MemCustomerRepository
import com.sbarrasa.bank.service.CustomerService
import io.ktor.server.routing.*

object CustomerModule {
    private val repository = MemCustomerRepository()
    private val service = CustomerService(repository)
    private val controller = CustomerController(service)

    fun register(route: Route) {
        controller.register(route)
    }
}