package com.example.hurlspringboot.model


fun processHelloOrGoodbye(text: String): HelloOrGoodbye = HelloOrGoodbye(helloOrGoodbye(text))


data class HelloOrGoodbye(
    val text: String,
    val timeStamp: Long = System.currentTimeMillis(),
)
