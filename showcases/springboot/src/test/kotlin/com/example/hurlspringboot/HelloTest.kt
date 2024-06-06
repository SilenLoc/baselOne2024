package com.example.hurlspringboot

import com.example.hurlspringboot.model.helloOrGoodbye
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe


class HelloTest: FunSpec( {


        context("old hello with no text"){
            val res: String = helloOrGoodbye("world")

            test("should contain either hello or goodbye"){
                (res.contains("hello") || res.contains("goodbye") && res.endsWith("world")) shouldBe true
            }
        }


        context("with no text, BetterHello should behave the same"){
            val res: BetterHello = BetterHello.hello("world")

            test("should contain either hello or goodbye"){
                (res.contains("hello") || res.contains("goodbye") || res.endsWith("world")) shouldBe true
            }
        }


})


@JvmInline
private value class BetterHello(val value: String) {

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
