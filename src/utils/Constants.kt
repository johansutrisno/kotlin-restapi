package com.example.utils

class Constants {
    companion object {
        const val DRIVER_NAME = "org.h2.Driver"
        // You can choose:
        const val IN_MEMORY_DATABASE = "jdbc:h2:mem:test"
        const val EMBEDDED_DATABASE = "jdbc:h2:./data/test"
        // Please read the different between two of them
    }
}