package com.sbarrasa.repository

import com.sbarrasa.util.id.Id

interface Repository<I, T: Id<I>> {
    fun getAll(): List<T>
    fun get(id: I): T
    fun add(entity: T): T
    fun update(id: I, entity: T): T
    fun delete(id: I): T
}
