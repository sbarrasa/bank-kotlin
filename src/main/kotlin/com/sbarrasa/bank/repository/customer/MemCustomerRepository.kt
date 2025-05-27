package com.sbarrasa.bank.repository.customer

import com.sbarrasa.bank.model.customer.Customer
import com.sbarrasa.repository.IntMemRepository


class MemCustomerRepository: CustomerRepository, IntMemRepository<Customer>()
