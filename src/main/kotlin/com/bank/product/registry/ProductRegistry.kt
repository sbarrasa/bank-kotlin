package com.bank.product.registry

import com.bank.product.structure.ProductDescriptor
import com.bank.product.structure.Product
import com.sbarrasa.id.map.Mappeable
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.*
import kotlinx.serialization.modules.*
import kotlinx.serialization.serializer
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance

typealias ProductClass = KClass<out Product>
typealias ProductSerializer = KSerializer<out Product>

open class ProductRegistry: Mappeable<String, String> {
   private val classes = mutableMapOf<ProductClass, ProductSerializer>()

   @OptIn(InternalSerializationApi::class)
   fun register(productClass: ProductClass) {
      classes[productClass] =  productClass.serializer()
   }

   val json: Json by lazy {
      Json {
         serializersModule = SerializersModule {
            polymorphic(Product::class) {
               classes.forEach { (productClass, serializer) ->
                  @Suppress("UNCHECKED_CAST")
                  subclass(productClass as KClass<Product>, serializer as KSerializer<Product>)
               }
            }
         }
         classDiscriminator = "id"
         ignoreUnknownKeys = true
      }
   }


   fun getDescriptor(productClass: ProductClass) = productClass.companionObjectInstance as ProductDescriptor

   fun createFrom(jsonString: String): Product =
      json.decodeFromString(jsonString)

   fun createFrom(map: Map<String, Any>): Product {
      val jsonObject = JsonObject(map.mapValues { (_, v) -> JsonPrimitive(v.toString()) })
      return json.decodeFromJsonElement(jsonObject)
   }

   override fun asMap() = classes.keys.associate { productClass ->
      val descriptor = getDescriptor(productClass)
      descriptor.id to descriptor.description
   }
}