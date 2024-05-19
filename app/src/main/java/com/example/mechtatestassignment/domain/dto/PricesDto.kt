package com.example.mechtatestassignment.domain.dto

data class PricesDto(
    val discountedPrice: Int? = null,
    val basePrice: Int? = null,
    val hasDiscount: Boolean? = null
)