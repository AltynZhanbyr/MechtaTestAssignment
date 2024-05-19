package com.example.mechtatestassignment.ui.screen.main

import com.example.mechtatestassignment.domain.model.Item

data class MainUiState(
    val pageInitial: Int = 1,
    val isLoading: Boolean = false,
    val message: String = "",
    val items: List<Item> = emptyList(),
    val endReached: Boolean = false,
    val bottomCircularState: Boolean = false,
    val canRetry: Boolean = false
)