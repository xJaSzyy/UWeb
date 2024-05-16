package com.stepan.lab5.controller

import com.stepan.lab5.data.Person
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
@Tag(name = "Пользователи", description = "Методы для работы с пользователями")
class PersonController {

    @GetMapping("/{id}")
    @Operation(summary = "Информация о пользователе по его id")
    fun getById(@PathVariable("id") id: Int) = Person(id, "Степан")

}