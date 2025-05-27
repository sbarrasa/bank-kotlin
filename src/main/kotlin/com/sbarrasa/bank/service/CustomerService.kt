package com.sbarrasa.bank.service

import com.sbarrasa.bank.entities.customer.Customer
import com.sbarrasa.bank.repository.CustomerRepository
import io.ktor.server.plugins.*

class CustomerService(private val repo: CustomerRepository) {

    fun update(id: Int, customer: Customer): Customer {
      val currentCustomer = getById(id)
      CustomerMapper.map(customer, currentCustomer)
      return repo.update(currentCustomer)
    }

    fun getAll(): List<Customer> {
        return repo.getAll()
    }

    fun getById(id: Int): Customer {
        return repo.getById(id)
            ?: throw NotFoundException("Id: ${id} no encontrado")
    }

    fun add(customer: Customer): Any {
        return repo.add(customer)
    }

    fun delete(id: Int): Customer {
        val customer = getById(id)
        repo.delete(id)
        return customer
    }
}