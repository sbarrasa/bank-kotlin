package com.sbarrasa.bank.model.product.factory

import com.sbarrasa.bank.model.product.Product
import com.sbarrasa.util.id.IdDescMap


typealias ProductCreator<T> = () -> T

object ProductRegistry: IdDescMap {
    private val creators = HashMap<String, ProductCreator<out Product>>()

    fun <T : Product> register(productRegister: ProductRegister<T>) =
        register(productRegister.id, productRegister.creator)

    fun <T : Product> register(productType: String, creator: ProductCreator<T>): ProductRegistry {
        creators[productType] = creator
        return this
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Product> create(productType: String): T {
        val creator = creators[productType]
            ?: throw ProductTypeNotRegistered(productType)
        return creator.invoke() as T
    }

    override fun asMap() =
        creators.mapValues { it.value().description }


}