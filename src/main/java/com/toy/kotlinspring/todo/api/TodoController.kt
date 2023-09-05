package com.toy.kotlinspring.todo.api

import com.toy.kotlinspring.todo.api.model.TodoRequest
import com.toy.kotlinspring.todo.api.model.TodoResponse
import com.toy.kotlinspring.todo.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val todoService : TodoService,
) {

    @GetMapping
    fun getAll() = ok(todoService.findAll())

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) = ok(TodoResponse.of(todoService.findById(id)))

    @PostMapping
    fun create(@RequestBody request : TodoRequest) = ok(TodoResponse.of(todoService.create(request)))

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: TodoRequest
    ) = ok(TodoResponse.of(todoService.update(id, request)))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : Long) : ResponseEntity<Unit> {
        todoService.delete(id)
        return noContent().build()
    }
}