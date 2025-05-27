package com.sbarrasa.repository

import com.sbarrasa.util.id.Id

open class MemRepository<I : Any?, T : Id<I>>(
    private val idGenerator: () -> I,
    val autoId: Boolean = true
): Repository<I, T> {

    protected val items = mutableMapOf<I, T>()

    override fun getAll(): List<T> = items.values.toList()

    override fun get(id: I): T? = items[id]

    override fun add(entity: T): T {
        if (autoId)
            entity.id = idGenerator()

        items[entity.id] = entity
        return entity
    }

    override fun update(entity: T): T {
        val id = entity.id
        items[id] = entity
        return entity
    }

    override fun delete(id: I): T {
        return items.remove(id)!!
    }
}