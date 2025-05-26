package com.sbarrasa.bank

import com.sbarrasa.bank.controller.CustomerRoutes
import com.sbarrasa.bank.repository.MemCustomerRepository
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*

fun main(){
    embeddedServer(
        Netty,
        port = 8080,
        host = "localhost",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    routing {
        CustomerRoutes.register(this, MemCustomerRepository())
    }
}