package com.sbarrasa.common.collections

import com.sbarrasa.common.text.Case
import com.sbarrasa.common.text.toCase
import kotlin.reflect.KClass


open class Catalog(val case: Case?) : LinkedHashMap<String, StringMap>() {
   private fun applyCase(key: String) = case?.let { key.toCase(it) } ?: key

   override fun put(key: String, value: StringMap): StringMap? {
      return super.put(applyCase(key), value)
   }

   fun put(clazz: KClass<*>, map:Map<*, *>): StringMap? {
      val className = clazz.simpleName
      requireNotNull(className) { Texts.NO_CLASS_NAME }
      return put(className, map.toStringMap())
   }

   fun put(map: Map<*, *>): StringMap? = put(map::class, map)

   fun put(mappeable: Mappeable<*, *>): StringMap?
      = put(mappeable::class, mappeable.asMap())

   fun <E> put(enumClass: KClass<E>, mapper: (E) -> String): StringMap?
         where E : Enum<E> {
      val map = enumClass.java.enumConstants.associate { it.name to mapper(it) }
      return put(enumClass, map)
   }


   fun <E : Any> put(elements: Iterable<E>, mapper: (E) -> Pair<String,String>): StringMap? {
      require(elements.any()) { Texts.EMPTY_ITERABLE }
      val clazz = elements.first()::class
      val map = elements.associate { mapper(it) }
      return put(clazz, map)
   }

   object Texts{
      var NO_CLASS_NAME = "Class must have simple name"
      var EMPTY_ITERABLE = "No se puede inferir clase de un iterable vacío"
   }
}

