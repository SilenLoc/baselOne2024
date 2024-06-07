package com.example.hurlspringboot.model


fun processHelloOrGoodbye(text: String): HelloOrGoodbye = HelloOrGoodbye(BetterHello.hello(text))


data class HelloOrGoodbye(
    val text: BetterHello,
    val timeStamp: Long = System.currentTimeMillis(),
)
