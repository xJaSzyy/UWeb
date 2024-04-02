package org.example

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.time.LocalDate
import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args: Array<String>) {
    /*val ctx: ApplicationContext = AnnotationConfigApplicationContext(ToDoConfig::class.java)

    val toDo: ToDo = ctx.getBean(ToDo::class.java)

    toDo.add(ToDoItem("Помыть посуду", Status.ACTIVE, LocalDate.now(), "Какая-то доп. информация"))
    toDo.add(ToDoItem("Убраться", Status.ACTIVE, LocalDate.now(), "Какая-то доп. информация"))
    toDo.add(ToDoItem("Погулять с собакой", Status.DONE, LocalDate.now(), "Какая-то доп. информация"))
    toDo.add(ToDoItem("Отдохнуть", Status.ACTIVE, LocalDate.now(), "Какая-то доп. информация"))

    toDo.add(ToDoItem("Сходить в ВУЗ", Status.ACTIVE, LocalDate.now(), "Какая-то доп. информация", mutableListOf(
        ToDoItem("Проснуться", Status.ACTIVE, LocalDate.now(), "1"),
        ToDoItem("Умыться", Status.ACTIVE, LocalDate.now(), ""),
        ToDoItem("Одеться", Status.ACTIVE, LocalDate.now(), "")
    )))

    toDo.listOutPut(toDo.listToDo())

    val items = toDo.search("Проснуться")
    items?.forEach{
        println("Описание: ${it.description}, Информация: ${it.information}\n")
    }

    toDo.add(ToDoItem("Проснуться", Status.ACTIVE, LocalDate.now(), "2"), toDo.find("Сходить в ВУЗ")!!)

    toDo.listOutPut(toDo.listToDo())*/


    val ctx: ApplicationContext = AnnotationConfigApplicationContext(ToDoConfig::class.java)
    val toDo: ToDo = ctx.getBean(ToDo::class.java)

    toDo.add(ToDoItem(description = "Первая задача"))
    toDo.add(ToDoItem(description = "Вторая задача"))
    toDo.add(ToDoItem(description = "Третья задача"))

    toDo.listOutPut(toDo.listToDo())
}

