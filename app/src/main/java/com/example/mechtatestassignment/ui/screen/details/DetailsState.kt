package com.example.mechtatestassignment.ui.screen.details

import com.example.mechtatestassignment.data.remote.dto.itemDetailsDto.DataDetailsDto

data class DetailsState(
    val isLoading: Boolean = false,
    val detailsDto: DataDetailsDto? = null,
    val message: String = ""
)