package com.toy.kotlinspring.todo.domain

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "todos")
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    var title: String,
    var description: String,
    var done: Boolean,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime? = null
) {



    fun update(title: String, description: String, done: Boolean) = let{
        this.title = title
        this.description = description
        this.done = done
        this.updatedAt = LocalDateTime.now()
    }
}
