package com.example

import com.example.service.DatabaseHelper
import com.example.service.UserService
import com.example.web.widget
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.jackson.jackson
import io.ktor.routing.Routing
import io.ktor.websocket.WebSockets

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    DatabaseHelper.init()
    install(DefaultHeaders)
    install(CallLogging)
    install(WebSockets)
    install(ContentNegotiation) {
        jackson { configure(SerializationFeature.INDENT_OUTPUT, true) }
    }
    install(Routing) { widget(userService = UserService()) }
}

