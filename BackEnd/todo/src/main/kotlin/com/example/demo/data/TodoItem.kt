package com.example.demo.data

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*

@Schema(description = "Информация о задаче")
@Entity
data class TodoItem(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    var text: String = "",
    var description: String = "",
    var state: StateType = StateType.Todo
)

enum class StateType {
    Todo,
    InProgress,
    Done
}
