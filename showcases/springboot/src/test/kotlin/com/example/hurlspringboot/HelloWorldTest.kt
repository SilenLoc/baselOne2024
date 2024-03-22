package com.example.hurlspringboot

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain


class HelloWorldTest: FunSpec( {

    context("with no text"){
        val res = helloWorld("")
        test("should contain either hello or world"){
            (res.contains("hello") || res.contains("world")) shouldBe true
        }
    }

    context("with text"){
        val res = helloWorld("baselone")
        test("should contain either world or hello and the text"){
            (res.contains("hello") || res.contains("world")) shouldBe true
            res shouldContain "baselone"
        }
    }
})