package com.example.mechtatestassignment.domain.model

data class Item(
    val id: Long,
    val name: String,
    val photos: List<String>,
    val price: Long,
    val code: String,
    val isFavorite: Boolean = false
)