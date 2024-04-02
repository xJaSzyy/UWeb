package org.example

class ToDo(private var toDoList: MutableList<ToDoItem> = mutableListOf()) {
    fun add(item: ToDoItem) = toDoList.add(item)

    fun delete(description: String) : Boolean = toDoList.removeIf{it.description.equals(description)}

    fun deleteActive() : Boolean = toDoList.removeIf{it.status.equals(Status.ACTIVE)}

    fun deleteDone() : Boolean = toDoList.removeIf{it.status.equals(Status.DONE )}

    fun deleteAll() = toDoList.clear()

    fun changeDescription(descriptionOld: String, descriptionNew: String) : Boolean {
        val item = find(descriptionOld)

        if (item != null) {
            toDoList[toDoList.indexOf(item)] = item.apply { this.description = descriptionNew }
            return true
        }
        else {
            return false
        }
    }

    fun changeStatus(description: String, status: Status) : Boolean {
        val item = find(description)

        if (item != null) {
            toDoList[toDoList.indexOf(item)] = item.apply { this.status = status }
            return true
        }
        else {
            return false
        }
    }

    fun listToDo(status: Status? = null) : List<ToDoItem> = when(status) {
        Status.ACTIVE -> toDoList.filter { it.status.equals(Status.ACTIVE) }
        Status.DONE -> toDoList.filter { it.status.equals(Status.DONE) }
        null -> toDoList
    }

    fun listOutPut(listToDo: List<ToDoItem>) {
        listToDo.forEach{
            println("Описание: ${it.description} Статус: ${it.status}")
        }
    }

    private fun find(description: String) : ToDoItem? = toDoList.find {it.description.equals(description)}
}