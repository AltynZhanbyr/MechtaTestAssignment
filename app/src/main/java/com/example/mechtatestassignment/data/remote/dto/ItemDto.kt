package com.example.mechtatestassignment.data.remote.dto

import com.example.mechtatestassignment.domain.model.Item
import com.google.gson.annotations.SerializedName

data class ItemDto(
    val id: Long,
    @SerializedName("xml_id")
    val xmlId: String,
    val name: String,
    val title: String,
    val code: String,
    val type: Long,
    val price: Long,
    val photos: List<String>,
    @SerializedName("city_exist")
    val cityExist: Boolean,
    @SerializedName("video_link")
    val videoLink: List<String>?,
    @SerializedName("code_1c")
    val code1c: String,
    val express: Boolean,
    @SerializedName("express_delivery")
    val expressDelivery: Boolean,
    @SerializedName("is_intercity")
    val isIntercity: Boolean,
    val rating: Double,
    @SerializedName("reviews_count")
    val reviewsCount: Long,
    @SerializedName("pod_order_item")
    val podOrderItem: Boolean,
    @SerializedName("pod_order_time")
    val podOrderTime: Any?,
    val preorder: Boolean,
    @SerializedName("preorder_start")
    val preorderStart: Any?,
    @SerializedName("preorder_sum")
    val preorderSum: Any?,
    @SerializedName("preorder_link")
    val preorderLink: Any?,
    val service: Boolean,
    val digital: Boolean,
    @SerializedName("in_compare")
    val inCompare: Boolean,
    @SerializedName("in_favorites")
    val inFavorites: Boolean,
    val stickers: Any?,
    @SerializedName("new_item")
    val newItem: Boolean,
    @SerializedName("same_product_properties")
    val sameProductProperties: List<String>,
    val metrics: MetricsDto,
    val availability: String,
    val prices: PricesDto,
    val bonus: Long,
    @SerializedName("has_gift")
    val hasGift: Boolean,
    val gifts: List<Any?>,
    @SerializedName("city_code_for_kaspi")
    val cityCodeForKaspi: String,
)

fun ItemDto.toModel() = Item(
    id = id,
    name = name,
    photos = photos,
    price = price
)