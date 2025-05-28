package com.sbarrasa.bank

import com.sbarrasa.bank.controller.CustomerController
import com.sbarrasa.bank.module.DBConnection
import com.sbarrasa.bank.repository.RepositoryRegistry
import com.sbarrasa.repository.EntityNotFoundException
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
import org.h2.tools.Server
import com.sbarrasa.util.MainArgs

fun main(args: Array<String>){
    val params = MainArgs(args)
    RepositoryRegistry.setType(params["repository"]?: "mem")

    DBConnection.init()

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
        handleException<EntityNotFoundException>(HttpStatusCode.NotFound)
    }

    routing {
        val controller = CustomerController(RepositoryRegistry.repository)
        controller.register(this)
    }

    val h2Server = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start()

    environment.monitor.subscribe(ApplicationStopped) {
        h2Server.stop()
    }
}

inline fun <reified T : Throwable> StatusPagesConfig.handleException(status: HttpStatusCode) {
    exception<T> { call, cause ->
        call.respond(status, cause.message ?: status.description)
    }
}

