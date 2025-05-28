package com.sbarrasa.bank.module

import com.sbarrasa.bank.repository.CustomersTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.Database

object DBConnection {
    fun init() {
        Database.connect(
            url = "jdbc:h2:file:/develop/data/db;DB_CLOSE_DELAY=-1;",
            driver = "org.h2.Driver",
            user = "root",
            password = ""
        )

        transaction {
            SchemaUtils.create(CustomersTable)
        }
    }
}