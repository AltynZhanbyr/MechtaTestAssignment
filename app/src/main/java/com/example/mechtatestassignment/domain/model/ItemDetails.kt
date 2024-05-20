package com.example.mechtatestassignment.domain.model

data class ItemDetails(
    val id: Long,
    val name: String,
    val photos: List<String>,
    val price: Long,
    val code: String,
    val properties: List<MainProperty>,
    val isFavorite: Boolean = false
)