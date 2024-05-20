package com.example.mechtatestassignment.data.remote.dto.itemDetailsDto

import com.google.gson.annotations.SerializedName

data class SameProducts(
    @SerializedName("same_products")
    val sameProducts: Map<String, ProductDetails>
)

data class ProductDetails(
    val items: Map<String, ItemDetails>,
    val name: String
)

data class ItemDetails(
    val link: String,
    val code: String,
    val id: Int,
    val value: String,
    val checked: Boolean,
    @SerializedName("hex_code")
    val hexCode: String? = null
)
