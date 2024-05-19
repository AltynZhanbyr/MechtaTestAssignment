package com.example.mechtatestassignment.ui.screen.main

import com.example.mechtatestassignment.domain.model.Item

data class MainUiState(
    val isLoading: Boolean = false,
    val message: String = "",
    val items: List<Item> = emptyList()
)