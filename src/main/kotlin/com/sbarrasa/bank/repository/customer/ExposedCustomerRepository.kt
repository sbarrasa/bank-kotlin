package com.sbarrasa.bank.repository.customer

import com.sbarrasa.bank.model.customer.Customer
import com.sbarrasa.util.ObjectMapper
import org.jetbrains.exposed.sql.transactions.transaction

class ExposedCustomerRepository : CustomerRepository {

    val toDTO = ObjectMapper{
        bindAll(CustomerEntity::class, Customer::class)
    }

    val toEntity = ObjectMapper{
        bindAll(Customer::class, CustomerEntity::class)
    }

    override fun getAll(): List<Customer> = transaction {
        CustomerEntity.all().map { toDTO.map(it, Customer()) }
    }

    override fun get(id: Int?): Customer? = transaction {
        val customerEntity = CustomerEntity.findById(id!!)
            ?: return@transaction null

        toDTO.map(customerEntity, Customer())
    }

    override fun add(entity: Customer): Customer = transaction {
        val created = CustomerEntity.new {}
        toEntity.map(entity, created)
        toDTO.map(created, Customer())
    }

    override fun update(entity: Customer): Customer? = transaction {
        val current = CustomerEntity.findById(entity.id!!)
            ?: return@transaction null
        toEntity.map(entity, current)
        toDTO.map(current, Customer())
    }

    override fun delete(id: Int?): Customer? = transaction {
        val existing = CustomerEntity.findById(id!!)
            ?: return@transaction null
        val customer = toDTO.map(existing, Customer())
        existing.delete()
        customer
    }
}