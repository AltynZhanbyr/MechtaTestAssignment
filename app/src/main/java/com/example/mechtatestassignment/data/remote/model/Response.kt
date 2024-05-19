package com.example.mechtatestassignment.data.remote.model

data class Response<T>(
    val result:Boolean?,
    val data: T?,
    val errors:List<Any?>,
)

