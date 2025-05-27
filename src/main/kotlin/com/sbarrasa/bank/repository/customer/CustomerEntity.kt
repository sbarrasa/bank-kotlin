package com.sbarrasa.bank.repository.customer

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CustomerEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CustomerEntity>(Customers)
    var name by Customers.firstName
    var lastName by Customers.lastName
    var birthDay by Customers.birthDay
    var gender by Customers.gender
}







