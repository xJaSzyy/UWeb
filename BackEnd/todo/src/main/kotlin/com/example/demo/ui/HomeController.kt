package com.example.demo.ui

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController {

    @GetMapping("/admin")
    fun getAdminPanel() : String {
        return "<h1> Hello admin </h1>"
    }

    @GetMapping("/welcome")
    fun getWelcome(): String {
        return "<h1> Welcome all </h1>"
    }
}