package com.sbarrasa.bank.repository

import com.sbarrasa.bank.model.customer.Customer
import com.sbarrasa.bank.service.*
import com.sbarrasa.repository.EntityNotFoundException
import org.jetbrains.exposed.sql.transactions.transaction

class ExposedCustomerRepository : CustomerRepository {


    override fun getAll(): List<Customer> = transaction {
        CustomerEntity.all().map {
            EntityToCustomer.map(it, Customer())
        }
    }

    override fun get(id: Int?): Customer = transaction {
        val customerEntity = findById(id)
        EntityToCustomer.map(customerEntity, Customer())
    }

    override fun add(entity: Customer): Customer = transaction {
        val created = CustomerEntity.new {}
        CustomerToEntity.map(entity, created)
        EntityToCustomer.map(created, Customer())
    }

    override fun update(id: Int?, entity: Customer): Customer = transaction {
        val current = findById(entity.id)
        CustomerToEntity.map(entity, current)
        EntityToCustomer.map(current, Customer())
    }

    private fun findById(id: Int?): CustomerEntity {
        return CustomerEntity.findById(id!!)
            ?: throw EntityNotFoundException("Id: $id no encontrado")

    }

    override fun delete(id: Int?): Customer = transaction {
        val existing = findById(id)
        val customer = EntityToCustomer.map(existing, Customer())
        existing.delete()
        customer
    }
}