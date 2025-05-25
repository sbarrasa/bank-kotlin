package com.sbarrasa.bank.controller

import com.sbarrasa.bank.customer.Customer
import com.sbarrasa.bank.repository.CustomerRepository
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.http.*
object CustomerRoutes {
    fun register(route: Route, repository: CustomerRepository) {
        with(route) {
            route("/customers") {
                get {
                    call.respond(repository.getAll())
                }
                get("/{id}") {
                    val id = call.parameters["id"]?.toIntOrNull()
                    val customer = id?.let { repository.getById(it) }
                    if (customer != null) {
                        call.respond(customer)
                    } else {
                        call.respondText("Customer not found", status = HttpStatusCode.NotFound)
                    }
                }
                post {
                    val customerRequest = call.receive<Customer>()
                    val customer = repository.add(customerRequest)
                    call.respond(customer)
                }
                put("/{id}") {
                    val id = call.parameters["id"]?.toIntOrNull()
                    val customerRequest = call.receive<Customer>()
                    customerRequest.id = id!!
                    val customerUpdated = id.let { repository.update(customerRequest) }
                    call.respond(customerUpdated)
                }
                delete("/{id}") {
                    val id = call.parameters["id"]?.toInt()
                    val customerRemoved = repository.delete(id!!)
                    call.respond(customerRemoved)
                }
            }
        }
    }
}