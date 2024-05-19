package com.example.mechtatestassignment.domain.dto

import com.google.gson.annotations.SerializedName

data class MetaTagsDto(
    val title: String? = null,
    val description: String? = null,
    val keywords: String? = null,
    @SerializedName("og:title")
    val ogTitle: String? = null,
    @SerializedName("og:type")
    val ogType: String? = null,
    @SerializedName("og:image")
    val ogImage: String? = null,
    @SerializedName("og:image:width")
    val ogImageWidth: String? = null,
    @SerializedName("og:image:height")
    val ogImageHeight: String? = null,
    val canonical: String? = null,
    @SerializedName("noindex")
    val noIndex: String? = null
)