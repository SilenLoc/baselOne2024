package com.example.hurlspringboot.api

import com.example.hurlspringboot.model.processHelloOrGoodbye
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
        @RequestParam("text") textOrNone: Optional<String>
    ): ResponseEntity<String> {

        val text = textOrNone.handleNone()
        val helloOrGoodbye = processHelloOrGoodbye(text).text

        return ResponseEntity.ok("- $helloOrGoodbye!")
    }

}

private fun Optional<String>.handleNone(): String = this.orElse("world")