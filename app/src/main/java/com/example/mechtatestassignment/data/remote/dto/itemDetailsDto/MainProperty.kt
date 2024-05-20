package com.example.mechtatestassignment.data.remote.dto.itemDetailsDto

import com.google.gson.annotations.SerializedName

data class MainProperty(
    @SerializedName("prop_name")
    val propName: String,
    @SerializedName("prop_name_description")
    val propNameDescription: String,
    @SerializedName("prop_value")
    val propValue: String,
    @SerializedName("prop_id")
    val propId: Long,
    val code: String,
    @SerializedName("section_code")
    val sectionCode: Any?,
)