package com.sbarrasa.bank.entities.product.factory

import com.sbarrasa.bank.entities.product.Product
import com.sbarrasa.bank.entities.product.ProductHeader

interface ProductRegister<T: Product>: ProductHeader {
    val creator: ProductCreator<T>
}