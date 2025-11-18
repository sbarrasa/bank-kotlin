package com.sbarrasa.kclass

import kotlin.reflect.KClass

open class ClassHierarchy<B : Any>(
   val baseClass: KClass<B>,
   val subClasses: MutableList<KClass<out B>> = mutableListOf()
)