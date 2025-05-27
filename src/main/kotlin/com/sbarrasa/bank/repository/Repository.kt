package com.sbarrasa.bank.repository

import com.sbarrasa.util.id.Id

interface Repository<I, T: Id<I>> {
    fun getAll(): List<T>
    fun get(id: I): T?
    fun add(entity: T): T
    fun update(entity: T): T
    fun delete(id: I): T
}
