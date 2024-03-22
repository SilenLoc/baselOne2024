package com.example.hurlspringboot

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api")
internal class Controller{

    @GetMapping("/healthz")
    fun healthz(): ResponseEntity<Unit> {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/protected")
    fun protected(): ResponseEntity<Unit> {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/protected/return")
    fun protectedReturn(
        @RequestParam("text") text: Optional<String>
    ): ResponseEntity<String> {
        return ResponseEntity.ok(helloWorld(text.orElse("from no one")))
    }


}

fun helloWorld(moreText: String): String{
    val res = listOf("hello", "world").random()
    return "$res, $moreText"
}

//@JvmInline
//value class HelloWorld(val text: String){
//
//}