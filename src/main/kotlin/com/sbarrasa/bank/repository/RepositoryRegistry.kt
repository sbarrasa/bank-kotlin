package com.sbarrasa.bank.repository

object RepositoryRegistry {
    private var type: String? = null
    private val map = mapOf(
        "mem" to MemCustomerRepository(),
        "exposed" to ExposedCustomerRepository()
    )

    val repository: CustomerRepository by lazy {
        val t = type ?: throw IllegalStateException("Repository type not set")
        map[t] ?: throw IllegalArgumentException("Repository $t not registered")
    }

    fun setType(type: String) {
        this.type = type
    }
}