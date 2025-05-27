package com.sbarrasa.bank.config

import com.sbarrasa.bank.controller.CustomerRoutes
import com.sbarrasa.bank.repository.MemCustomerRepository
import com.sbarrasa.bank.service.CustomerService
import io.ktor.server.routing.*

object CustomerModule {
    val repository = MemCustomerRepository()
    val service = CustomerService(repository)
    val routes = CustomerRoutes(service)

    fun register(route: Route) {
        routes.register(route)
    }
}