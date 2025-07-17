package com.appvibe.todo.data

import com.appvibe.todo.R
import com.appvibe.todo.domain.Category
import com.appvibe.todo.domain.TodoItem
import com.appvibe.todo.presentation.model.DropDown
import java.sql.Date

object Dummy {
    fun menuItemList(): List<DropDown> {
        return listOf(
            DropDown(1, "Today", true),
            DropDown(2, "Yesterday", false),
            DropDown(3, "Tomorrow", false)
        )
    }

    fun categoryList(): List<Category> {
        return listOf(
            Category(1, "Work", 0xFFFFCC80.toInt(), R.drawable.ic_ellipse),
            Category(2, "Personal", 0xFF80DEEA.toInt(), R.drawable.ic_check_list),
            Category(3, "Study", 0xFFFFF59D.toInt(), R.drawable.ic_tag),
            Category(4, "Shopping", 0xFFA5D6A7.toInt(), R.drawable.ic_back),
            Category(5, "Fitness", 0xFFEF9A9A.toInt(), R.drawable.ic_add_task),
        )
    }

    fun todoList(): List<TodoItem> {
        return listOf(
            TodoItem(
                id = 1,
                taskDescription = "Complete project proposal",
                priority = 1,
                category = categoryList()[0],
                createdDate = Date(
                    System.currentTimeMillis()
                ),
                isCompleted = true,
                todoDate = Date(System.currentTimeMillis())
            ),
            TodoItem(
                id = 2,
                taskDescription = "Buy groceries for the week",
                priority = 2,
                category = categoryList()[3],
                createdDate = Date(
                    System.currentTimeMillis() - 24 * 60 * 60 * 1000 // Yesterday
                ),
                isCompleted = true,
                todoDate = Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000) // Yesterday
            ),
            TodoItem(
                id = 3,
                taskDescription = "Read chapter 5 of the book",
                priority = 3,
                category = categoryList()[2],
                createdDate = Date(
                    System.currentTimeMillis()
                ),
                isCompleted = false,
                todoDate = Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000) // Tomorrow
            ),
            TodoItem(
                id = 4,
                taskDescription = "Go for a 30-minute run",
                priority = 1,
                category = categoryList()[4],
                createdDate = Date(
                    System.currentTimeMillis()
                ),
                isCompleted = false,
                todoDate = Date(System.currentTimeMillis())
            ),
            TodoItem(
                id = 5,
                taskDescription = "Call mom for her birthday",
                priority = 2,
                category = categoryList()[1],
                createdDate = Date(
                    System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000 // Two days ago
                ),
                isCompleted = true,
                todoDate = Date(System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000) // Two days ago
            )

        )
    }
}