package com.example.service

import com.example.model.UsersTable
import com.example.utils.Constants
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.coroutines.CoroutineContext

object DatabaseHelper {
    private val dispatcher: CoroutineContext

    init {
        dispatcher = newFixedThreadPoolContext(4, "database-pool")
    }

    fun init() {
        Database.connect(hikari())
        transaction {
            create(UsersTable)
            // jika ingin memasukan data dummy :
//            UsersTable.insert { p0 ->
//                p0[name] = "Johan Sutrisno"
//                p0[phone] = "085863975973"
//                p0[email] = "johansutrisno@gmail.com"
//                p0[last_edited] = System.currentTimeMillis()
//            }
        }
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = Constants.DRIVER_NAME
        // Gunakan EMBEDDED_DATABASE buat simpan database di hdd
        // gunakan IN_MEMORY buat simpan database ke RAM
        // selengkapnya anda bisa baca-baca soal embedded database dan in memory database :)
        config.jdbcUrl = Constants.EMBEDDED_DATABASE
        config.maximumPoolSize = 3
        config.isAutoCommit = true
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }

    suspend fun <T> dbQuery(block: () -> T): T =
        withContext(dispatcher) { transaction { block() } }
}