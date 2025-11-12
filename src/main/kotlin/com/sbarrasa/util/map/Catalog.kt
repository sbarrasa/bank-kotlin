package com.sbarrasa.util.map

import com.sbarrasa.util.id.Desc
import com.sbarrasa.util.id.EnumDescMappeable
import com.sbarrasa.util.case.*
import kotlin.reflect.KClass

open class Catalog(val case: Case?) : LinkedHashMap<String, Map<String, String>>() {
   private fun applyCase(key: String) = case?.let { key.toCase(it) } ?: key

   override fun put(key: String, value: Map<String, String>): Map<String, String>? {
      return super.put(applyCase(key), value)
   }


   fun put(clazz: KClass<*>, map:Map<*, *>): Map<String, String>?
      = put(clazz.simpleName!!, map.toStrMap())

   fun put(map: Map<*, *>): Map<String, String>? = put(map::class, map)

   fun put(mappeable: Mappeable<*, *>): Map<String, String>?
      = put(mappeable::class, mappeable.asMap())

   fun <E> put(enumClass: KClass<E>): Map<String, String>? where E : Enum<E>, E : Desc {
      return put(enumClass, EnumDescMappeable(enumClass).asMap())
   }
}

fun Map<*,*>.toStrMap(): Map<String, String> =
   mapKeys { it.key.toString() }
      .mapValues { it.value.toString() }
