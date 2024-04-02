package org.example


data class ToDoItem(var description: String, var status: Status) {

}

enum class Status {
    DONE, ACTIVE
}
