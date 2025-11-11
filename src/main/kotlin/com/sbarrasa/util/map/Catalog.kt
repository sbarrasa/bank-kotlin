package com.sbarrasa.util.map

import com.sbarrasa.util.id.Desc
import com.sbarrasa.util.id.EnumDescMappeable
import com.sbarrasa.util.case.*
import kotlin.reflect.KClass

open class Catalog(val case: Case?) : LinkedHashMap<String, Map<*, *>>() {
   private fun applyCase(key: String) = case?.let { key.toCase(it) } ?: key

   override fun put(key: String, value: Map<*, *>): Map<*, *>?
      = super.put(applyCase(key), value)

   fun put(clazz: KClass<*>, map:Map<*, *>): Map<*, *>?
      = put(clazz.simpleName!!, map)

   fun put(map: Map<*, *>): Map<*, *>? = put(map::class, map)

   fun put(mappeable: Mappeable<*, *>): Map<*, *>?
      = put(mappeable::class, mappeable.asMap())

   fun <E> put(enumClass: KClass<E>): Map<*,*>? where E : Enum<E>, E : Desc {
      return put(enumClass, EnumDescMappeable(enumClass).asMap())
   }


}