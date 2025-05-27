package com.sbarrasa.bank.model.product.factory

import com.sbarrasa.bank.model.product.Product
import com.sbarrasa.bank.model.product.ProductHeader

interface ProductRegister<T: Product>: ProductHeader {
    val creator: ProductCreator<T>
}