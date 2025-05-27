package com.sbarrasa.bank

import com.sbarrasa.bank.config.CustomerModule
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*


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

    install(StatusPages) {
        handleException<BadRequestException>(HttpStatusCode.BadRequest)
        handleException<NotFoundException>(HttpStatusCode.NotFound)
    }

    routing {
        CustomerModule.register(this)
    }
}

inline fun <reified T : Throwable> StatusPagesConfig.handleException(status: HttpStatusCode) {
    exception<T> { call, cause ->
        call.respond(status, cause.message ?: status.description)
    }
}

