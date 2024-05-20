package com.example.mechtatestassignment.ui.screen.details

import com.example.mechtatestassignment.domain.model.ItemDetails

data class DetailsState(
    val isLoading: Boolean = false,
    val details: ItemDetails? = null,
    val message: String = ""
)