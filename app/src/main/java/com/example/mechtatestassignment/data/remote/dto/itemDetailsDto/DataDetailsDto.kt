package com.example.mechtatestassignment.data.remote.dto.itemDetailsDto

import com.example.mechtatestassignment.data.remote.dto.itemListDto.MetricsDto
import com.google.gson.annotations.SerializedName

data class DataDetailsDto(
    val id: Long,
    @SerializedName("xml_id")
    val xmlId: String,
    val name: String,
    val title: String,
    val code: String,
    val type: Long,
    val photos: List<String>,
    @SerializedName("video_link")
    val videoLink: Any?,
    @SerializedName("code_1c")
    val code1c: String,
    val rating: Long,
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
    @SerializedName("new_item")
    val newItem: Boolean,
    val metrics: MetricsDto,
    val bonus: Long,
    @SerializedName("kaspi_code")
    val kaspiCode: String,
    @SerializedName("in_basket")
    val inBasket: Boolean,
    @SerializedName("meta_tags")
    val metaTags: MetaTagsDetailsDto,
    val breadcrumbs: List<BreadcrumbDetailsDto>,
    @SerializedName("main_properties")
    val mainProperties: List<MainProperty>,
    val properties: Properties,
    val stream24: StreamDto,
    @SerializedName("equal_products_model_id")
    val equalProductsModelId: Long,
    val availability: String,
    @SerializedName("city_exist")
    val cityExist: Boolean,
    @SerializedName("delivery_info")
    val deliveryInfo: DeliveryInfoDto,
    val express: Boolean,
    @SerializedName("express_delivery")
    val expressDelivery: Boolean,
    val gifts: List<Any?>,
    @SerializedName("has_gift")
    val hasGift: Boolean,
    @SerializedName("is_intercity")
    val isIntercity: Boolean,
    @SerializedName("only_vit")
    val onlyVit: Boolean,
    val price: Long,
    val prices: PricesDto,
    @SerializedName("same_product_properties")
    val sameProductProperties: List<String>,
    @SerializedName("same_products")
    val sameProducts: SameProducts,
    val shops: List<Shop>,
    val stickers: List<Any?>,
)

data class Shop(
    @SerializedName("shop_name")
    val shopName: String,
    val coordinates: Coordinates,
    @SerializedName("work_time")
    val workTime: String,
    @SerializedName("work_time_short")
    val workTimeShort: String,
    @SerializedName("items_count_real")
    val itemsCountReal: Long,
    @SerializedName("items_count")
    val itemsCount: Double,
)

data class Coordinates(
    val latitude: Double,
    val longitude: Double,
)

