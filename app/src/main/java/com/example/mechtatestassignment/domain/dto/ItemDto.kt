package com.example.mechtatestassignment.domain.dto

import com.google.gson.annotations.SerializedName

data class ItemDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("xml_id")
    val xmlId: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("type")
    val type: Int? = null,
    @SerializedName("price")
    val price: Int? = null,
    @SerializedName("photos")
    val photos: List<String> = emptyList(),
    @SerializedName("city_exist")
    val cityExist: Boolean? = null,
    @SerializedName("video_link")
    val videoLink: String? = null,
    @SerializedName("code_1c")
    val code1c: String? = null,
    @SerializedName("express")
    val express: Boolean? = null,
    @SerializedName("express_delivery")
    val expressDelivery: Boolean? = null,
    @SerializedName("is_intercity")
    val isIntercity: Boolean? = null,
    @SerializedName("rating")
    val rating: Int? = null,
    @SerializedName("reviews_count")
    val reviewsCount: Int? = null,
    @SerializedName("pod_order_item")
    val podOrderItem: Boolean? = null,
    @SerializedName("pod_order_time")
    val podOrderTime: String? = null,
    @SerializedName("preorder")
    val preorder: Boolean? = null,
    @SerializedName("preorder_start")
    val preorderStart: String? = null,
    @SerializedName("preorder_sum")
    val preorderSum: String? = null,
    @SerializedName("preorder_link")
    val preorderLink: String? = null,
    @SerializedName("service")
    val service: Boolean? = null,
    @SerializedName("digital")
    val digital: Boolean? = null,
    @SerializedName("in_compare")
    val inCompare: Boolean? = null,
    @SerializedName("in_favorites")
    val inFavorites: Boolean? = null,
    @SerializedName("stickers")
    val stickers: StickersDto? = null,
    @SerializedName("new_item")
    val newItem: Boolean? = null,
    @SerializedName("same_product_properties")
    val sameProductProperties: List<String> = emptyList(),
    @SerializedName("metrics")
    val metrics: MetricsDto? = null,
    @SerializedName("availability")
    val availability: String? = null,
    @SerializedName("prices")
    val prices: PricesDto? = null,
    @SerializedName("bonus")
    val bonus: Int? = null,
    @SerializedName("has_gift")
    val hasGift: Boolean? = null,
    @SerializedName("gifts")
    val gifts: List<String> = emptyList(),
    @SerializedName("city_code_for_kaspi")
    val cityCodeForKaspi: String? = null
)