package com.sbarrasa.bank.repository

import com.sbarrasa.bank.model.customer.Customer
import com.sbarrasa.bank.service.CustomerMapper
import com.sbarrasa.repository.IntMemRepository


class MemCustomerRepository: CustomerRepository, IntMemRepository<Customer>(){
    override fun update(id: Int?, entity: Customer): Customer {
            val currentEntity = get(id)
            CustomerMapper.map(entity, currentEntity)
            return super.update(id, currentEntity)
    }

}