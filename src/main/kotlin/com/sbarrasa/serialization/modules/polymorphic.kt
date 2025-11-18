package com.sbarrasa.serialization.modules

import com.sbarrasa.kclass.ClassHierarchy
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.modules.SerializersModuleBuilder
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

@OptIn(InternalSerializationApi::class)
fun <B: Any> SerializersModuleBuilder.polymorphic(classHierarchy: ClassHierarchy<B>) =
   polymorphic(classHierarchy.baseClass, classHierarchy.subClasses)

@OptIn(InternalSerializationApi::class)
fun <B : Any> SerializersModuleBuilder.polymorphic(
   baseClass: KClass<B>,
   subclasses: List<KClass<out B>>) {
   polymorphic(baseClass) {
      subclasses.forEach { subclass ->
         @Suppress("UNCHECKED_CAST")
         subclass(subclass as KClass<B>, subclass.serializer())
      }
   }
}
