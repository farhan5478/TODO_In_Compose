package com.appvibe.todo.domain

import java.sql.Date

data class TodoItem(
    val id: Long,
    val taskDescription: String,
    val priority: Int,
    val category: Category,
    val createdDate: Date,
    val isCompleted: Boolean,
    val todoDate: Date
)
