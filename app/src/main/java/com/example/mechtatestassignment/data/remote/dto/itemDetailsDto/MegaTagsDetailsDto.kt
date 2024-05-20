package com.example.mechtatestassignment.data.remote.dto.itemDetailsDto

import com.google.gson.annotations.SerializedName

data class MetaTagsDetailsDto(
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
    @SerializedName("og:site_name")
    val ogSiteName: String,
    @SerializedName("og:description")
    val ogDescription: String,
)