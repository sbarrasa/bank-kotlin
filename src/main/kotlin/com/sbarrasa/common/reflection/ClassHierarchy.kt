package com.sbarrasa.common.reflection

import kotlin.reflect.KClass

open class ClassHierarchy<B : Any>(
   val baseClass: KClass<B>,
   val subClasses: MutableList<KClass<out B>> = mutableListOf()
)