package com.example.mechtatestassignment.data.remote.dto.itemListDto

import com.google.gson.annotations.SerializedName

data class MetaTagsDto(
    val title: String,
    val description: String,
    val keywords: String,
    @SerializedName("og:title")
    val ogTitle: String,
    @SerializedName("og:type")
    val ogType: String,
    @SerializedName("og:image")
    val ogImage: String,
    @SerializedName("og:image:width")
    val ogImageWidth: String,
    @SerializedName("og:image:height")
    val ogImageHeight: String,
    val canonical: Any?,
    val noindex: Any?,
)