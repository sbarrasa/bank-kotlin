package com.sbarrasa.repository

import com.sbarrasa.id.Id
import com.sbarrasa.id.generators.IdGen


open class MemRepository<I : Any, T : Id<I?>>(
   private val idGenerator: IdGen<I>? = null
) : Repository<I, T> {

   protected val items = mutableMapOf<I, T>()

   override fun getAll(): List<T> = items.values.toList()

   override fun get(id: I): T = items[id]
      ?: throw EntityNotFoundException(id = id)

   override fun add(dto: T): T {
      if (idGenerator!=null)
         dto.id = idGenerator.next()

      items[dto.id!!] = dto
      return dto
   }

   override fun update(id: I, dto: T): T {
      items[id] = dto
      return dto
   }

   override fun delete(id: I): T {
      return items.remove(id)
         ?: throw EntityNotFoundException(id = id)
   }
}