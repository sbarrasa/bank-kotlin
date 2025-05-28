package com.sbarrasa.bank.repository

import com.sbarrasa.bank.model.customer.Customer
import com.sbarrasa.repository.Repository

interface CustomerRepository: Repository<Int?, Customer>