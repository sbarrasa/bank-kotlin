package com.bank.repository

import com.bank.config.DBClient
import java.util.logging.Logger

object RepositoryFactory {
   private val log = Logger.getLogger(this::class.simpleName)

   enum class Types {
      MEM, EXPOSED
   }


   fun get(type: Types): CustomerRepository {
      log.info("Repository type: $type")
      return when (type) {
         Types.MEM -> MemCustomerRepository
         Types.EXPOSED -> {
            DBClient.init(CustomersTable)
            ExposedCustomerRepository
         }
      }
   }

   fun get(typeStr: String?): CustomerRepository {
      return get(Types.valueOf(typeStr ?: Types.MEM.name))
   }
}