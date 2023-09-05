package com.toy.kotlinspring.todo.api.model

data class TodoRequest(
    private val title : String,
    private val description : String,
    private val done : Boolean,
) {

}
