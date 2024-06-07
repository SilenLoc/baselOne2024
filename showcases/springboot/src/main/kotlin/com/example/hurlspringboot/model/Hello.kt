package com.example.hurlspringboot.model






fun helloOrGoodbye(text: String): String{
    val res = listOf("hello", "goodbye").random()
    return "$res, $text"
}

@JvmInline
value class BetterHello(val value: String) {

    override fun toString(): String {
        return this.value
    }

    fun contains(text: String): Boolean{
        return value.contains(text)
    }

    fun endsWith(text: String): Boolean{
        return value.endsWith(text)
    }

    companion object{
        fun hello(text: String): BetterHello = BetterHello("${listOf("hello", "goodbye").random()}, $text")
    }
}

