package com.sbarrasa.common.id

import com.sbarrasa.common.id.map.Mappeable
import kotlin.reflect.KClass

class EnumDescMappeable<E>(val enumClass: KClass<E>): Mappeable<E, String> where E : Enum<E>, E : Desc {
   override fun asMap(): Map<E, String> {
      return enumClass.java.enumConstants.associate { it to it.description }
   }
}

