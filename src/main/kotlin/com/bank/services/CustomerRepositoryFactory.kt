package com.bank.services

import com.bank.repository.customer.CustomerProductsTable
import com.bank.repository.customer.CustomerRepository
import com.bank.repository.customer.CustomersTable
import com.bank.repository.customer.ExposedCustomerRepository
import com.bank.repository.customer.MemCustomerRepository
import com.sbarrasa.common.registry.RegistryFactory

object CustomerRepositoryFactory: RegistryFactory<String, CustomerRepository>() {
   init {
      register("MEM") { MemCustomerRepository }

      register("EXPOSED") {
         DBClient.init(CustomersTable, CustomerProductsTable)
         ExposedCustomerRepository
      }
   }
}