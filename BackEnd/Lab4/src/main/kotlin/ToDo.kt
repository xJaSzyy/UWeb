package org.example

class ToDo(private var toDoList: MutableList<ToDoItem> = mutableListOf()) {
    fun add(item: ToDoItem) = toDoList.add(item)

    fun delete(description: String) : Boolean = toDoList.removeIf{it.description.equals(description)}

    fun deleteActive() : Boolean = toDoList.removeIf{it.status.equals(Status.ACTIVE)}

    fun deleteDone() : Boolean = toDoList.removeIf{it.status.equals(Status.DONE )}

    fun deleteAll() = toDoList.clear()

    fun listToDo(status: Status? = null) : List<ToDoItem> = when(status) {
        Status.ACTIVE -> toDoList.filter { it.status.equals(Status.ACTIVE) }
        Status.DONE -> toDoList.filter { it.status.equals(Status.DONE) }
        null -> toDoList
    }

    fun listOutPut(listToDo: List<ToDoItem>) {
        listToDo.forEach{
            println("id: ${it.id}, Описание: ${it.description}, Статус: ${it.status}, Дата: ${it.date}, Доп. информация: ${it.information}")
        }
        println()
    }

    fun find(description: String) : ToDoItem? = toDoList.find { it.description == description }
}