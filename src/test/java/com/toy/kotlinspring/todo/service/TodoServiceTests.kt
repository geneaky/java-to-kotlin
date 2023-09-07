package com.toy.kotlinspring.todo.service

import com.ninjasquad.springmockk.MockkBean
import com.toy.kotlinspring.todo.domain.Todo
import com.toy.kotlinspring.todo.domain.TodoRepository
import io.mockk.every
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime
import java.util.*

@ExtendWith(SpringExtension::class)
class TodoServiceTests {

    @MockkBean
    lateinit var repository: TodoRepository
    lateinit var service: TodoService

    val stub : Todo by lazy {
        Todo(
            id = 1,
            title = "test",
            description = "test detail",
            done = false,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        )
    }

    @BeforeEach
    fun setUp() {
        service = TodoService(repository)
    }

    @Test
    fun `한개의 TODO를 반환해야한다`() {
        every { repository.findByIdOrNull(1) } returns stub
        val actual = service.findById(1L)
        assertThat(actual).isNotNull()
        assertThat(actual).isEqualTo(stub)
    }


}