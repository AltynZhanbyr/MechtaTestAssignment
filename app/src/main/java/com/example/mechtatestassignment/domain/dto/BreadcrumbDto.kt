package com.example.mechtatestassignment.domain.dto

import com.google.gson.annotations.SerializedName

data class BreadcrumbDto(
    val name: String,
    val code: String,
    @SerializedName("name_ru")
    val nameRu: String?,
    val id: Long?,
)