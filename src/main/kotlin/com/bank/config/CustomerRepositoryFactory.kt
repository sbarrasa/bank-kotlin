package com.bank.config

import com.bank.repository.CustomerRepository
import com.bank.repository.CustomersTable
import com.bank.repository.ExposedCustomerRepository
import com.bank.repository.MemCustomerRepository
import com.sbarrasa.repository.AbstractRepositoryFactory

object CustomerRepositoryFactory: AbstractRepositoryFactory<CustomerRepository>() {
   override fun buildRepositories() = mutableMapOf(
      "MEM" to { MemCustomerRepository },
      "EXPOSED" to {
         DBClient.init(CustomersTable)
         ExposedCustomerRepository
      }
   )
}