package com.sbarrasa.bank.repository

import com.sbarrasa.bank.entities.customer.Customer


open class MemCustomerRepository: CustomerRepository {
    private val items = mutableMapOf<Int, Customer>()
    private var nextId = 1
    override fun getAll(): List<Customer> = items.values.toList()

    override fun getById(id: Int?): Customer = items[id]
        ?: throw NoSuchElementException("Not found: $id")

    override fun add(entity: Customer): Customer {
        entity.id = nextId++
        items[entity.id!!] = entity
        return entity
    }

    override fun update(entity: Customer): Customer {
        val id = entity.id
        items[id!!] = entity
        return entity
    }

    override fun delete(id: Int?): Customer = items.remove(id)
        ?: throw NoSuchElementException("Not found: $id")
}
