package com.bank.repository

import com.bank.model.customer.Customer
import com.sbarrasa.exposed.repository.ExposedRepository
import com.sbarrasa.util.ObjectMapper

class ExposedCustomerRepository :
   CustomerRepository, ExposedRepository<Customer, CustomerEntity>(
   entityClass = CustomerEntity,
   mapToDTO = { DTOMapper.map(it, Customer()) },
   mapToEntity = { dto, dbEntity -> EntityMapper.map(dto, dbEntity) }
) {
   object EntityMapper : ObjectMapper<Customer, CustomerEntity>({
      bindAll(Customer::class, CustomerEntity::class)
   })

   object DTOMapper : ObjectMapper<CustomerEntity, Customer>({
      bindAll(CustomerEntity::class, Customer::class)
      bind({ it.id.value }, Customer::id)
  })
}