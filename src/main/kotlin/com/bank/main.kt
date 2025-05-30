package com.bank

import com.bank.modules.*
import com.bank.model.product.factory.ProductRegistry
import com.bank.modules.Repository
import com.sbarrasa.util.args.get
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    H2Server.start()
    ProductRegistry.init()
    Repository.set(args[Repository.paramKey])
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
    H2Server.stop()
}



