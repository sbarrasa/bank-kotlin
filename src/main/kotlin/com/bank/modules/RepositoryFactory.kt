package com.bank.modules

import com.bank.repository.ExposedCustomerRepository
import com.bank.repository.MemCustomerRepository
import java.util.logging.Logger

object RepositoryFactory {
   private val log = Logger.getLogger(this::class.simpleName)
   enum class Types {
      MEM, EXPOSED
   }

   const val paramKey = "repo"

   var type: Types = Types.MEM

   fun create() = when (type) {
      Types.MEM -> MemCustomerRepository()
      Types.EXPOSED -> {
         DBClient.init()
         ExposedCustomerRepository()
      }
   }


   fun setType(typeStr: String?) {
      log.info("Repository type: $typeStr")
      type = typeStr
         ?.let { Types.valueOf(it) }
         ?: Types.MEM

   }
}