package org.example

import java.time.LocalDate

data class ToDoItem(
    var id: Int = generateId(),
    var description: String,
    var status: Status = Status.ACTIVE,
    var date: LocalDate = LocalDate.now(),
    var information: String = "",
    var items: MutableList<Int> = mutableListOf()
) {
    companion object {
        private var currentId = 0

        fun generateId(): Int {
            return currentId++
        }
    }
}

enum class Status {
    DONE, ACTIVE
}
