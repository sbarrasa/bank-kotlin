package com.bank.routes

import com.bank.modules.CodesCatalog
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


object CodesRoutes {
   fun register(parent: Route) {

      parent.route("/codes") {
         get("/all") {
            call.respond(CodesCatalog)
         }

         get("/") {
            call.respond(CodesCatalog.keys)
         }

         get("/{code}") {
            val code = call.parameters["code"]
            CodesCatalog[code]
               ?.let { call.respond(it) }
               ?: throw NotFoundException("Code $code not found")
         }
      }
   }
}