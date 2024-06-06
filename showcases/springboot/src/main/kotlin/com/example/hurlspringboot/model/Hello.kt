package com.example.hurlspringboot.model






fun helloOrGoodbye(text: String): String{
    val res = listOf("hello", "goodbye").random()
    return "$res, $text"
}



