package com.bank.repository

import com.bank.model.customer.Customer
import com.sbarrasa.exposed.repository.ExposedRepository
import com.sbarrasa.util.objectmapper.*

class ExposedCustomerRepository :
   CustomerRepository, ExposedRepository<Customer, CustomerEntity>(
   entityClass = CustomerEntity,
   mapToDTO = { entity ->
      val dto = Customer()
      map(entity, dto)
      dto
   },
   mapToEntity = { dto, entity ->
      map(dto, entity)
      entity
   }
)
