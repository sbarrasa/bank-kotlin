package com.bank.repository

import com.bank.model.customer.Customer
import com.sbarrasa.repository.IntMemRepository
import com.sbarrasa.util.objectmapper.map


class MemCustomerRepository : CustomerRepository, IntMemRepository<Customer>() {
   override fun update(id: Int?, dto: Customer): Customer {
      val currentEntity = get(id)
      map(dto, currentEntity)
      return super.update(id, currentEntity)
   }

}