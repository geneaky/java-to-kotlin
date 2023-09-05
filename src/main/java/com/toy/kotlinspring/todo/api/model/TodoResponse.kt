package com.toy.kotlinspring.todo.api.model

import com.toy.kotlinspring.todo.domain.Todo
import java.time.LocalDateTime

data class TodoResponse(
    private var id: Long,
    private var title : String,
    private val description: String,
    private val done: Boolean,
    private val createdAt: LocalDateTime,
    private val updatedAt: LocalDateTime,
) {

    companion object {
        fun of(todo: Todo?) : TodoResponse {
            checkNotNull(todo) {"Todo is Null"}

            return TodoResponse(
                id = todo.id,
                title = todo.title,
                description = todo.description,
                done = todo.done,
                createdAt = todo.createdAt,
                updatedAt = todo.updatedAt,
            )
        }
    }
}
