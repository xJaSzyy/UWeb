package com.example.demo.ui

import com.example.demo.data.TodoItem
import com.example.demo.data.TodoRepository
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todo")
class TodoController(@Autowired private val repository: TodoRepository) {
    @GetMapping("/")
    @Operation(summary = "Получить все задачи")
    fun getAll(): ResponseEntity<List<TodoItem>> {
        val todos = repository.findAll()
        return ResponseEntity.status(HttpStatus.OK).body(todos)
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить задачу по id")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        val todoItem = repository.findById(id)
        return if (todoItem.isPresent) {
            ResponseEntity.status(HttpStatus.OK).body(todoItem.get())
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Задача с id $id не найдена")
        }
    }

    @PostMapping("/")
    @Operation(summary = "Добавление задачи")
    fun create(@RequestBody todoItem: TodoItem): ResponseEntity<Any> {
        repository.save(todoItem)
        return ResponseEntity.status(HttpStatus.OK).body("Задача успешно добавлена")
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменить задачу по её id")
    fun update(@PathVariable id: Long, @RequestBody todoItem: TodoItem): ResponseEntity<Any> {
        val existingTodo = repository.findById(id).orElse(null)
        return if (existingTodo != null) {
            existingTodo.text = todoItem.text
            existingTodo.description = todoItem.description
            existingTodo.state = todoItem.state
            repository.save(existingTodo)
            ResponseEntity.status(HttpStatus.OK).body("Задача с id $id успешно изменена $existingTodo")
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Задача с id $id не найдена")
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление задачи")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        val existingTodo = repository.findById(id)
        return if (existingTodo.isPresent) {
            repository.deleteById(id)
            ResponseEntity.status(HttpStatus.OK).body("Задача успешно удалена")
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Задача с id $id не найдена")
        }
    }
}

