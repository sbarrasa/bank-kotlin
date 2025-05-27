package com.sbarrasa.bank.repository

import com.sbarrasa.bank.entities.customer.Customer


open class MemCustomerRepository: CustomerRepository {
    private val items = mutableMapOf<Int, Customer>()
    private var nextId = 1
    override fun getAll(): List<Customer> {
        return items.values.toList()
    }

    override fun get(id: Int?): Customer? {
        return items[id]
    }

    override fun add(entity: Customer): Customer {
        entity.id = nextId++
        items[entity.id!!] = entity
        return entity
    }

    override fun update(entity: Customer): Customer {
        items[entity.id!!] = entity
        return entity
    }

    override fun delete(id: Int?): Customer {
        return items.remove(id)
            ?: throw NoSuchElementException("Not found: $id")
    }
}
