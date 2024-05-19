package com.example.mechtatestassignment.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PricesDto(
    @SerializedName("discounted_price")
    val discountedPrice: Long,
    @SerializedName("base_price")
    val basePrice: Long,
    @SerializedName("has_discount")
    val hasDiscount: Boolean,
)