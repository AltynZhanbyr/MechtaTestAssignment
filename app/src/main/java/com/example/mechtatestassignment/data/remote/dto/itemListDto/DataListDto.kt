package com.example.mechtatestassignment.data.remote.dto.itemListDto

import com.google.gson.annotations.SerializedName

data class DataListDto(
    @SerializedName("section_list")
    val sectionList: List<SectionDto>,
    @SerializedName("all_items_count")
    val allItemsCount: Long,
    @SerializedName("page_items_count")
    val pageItemsCount: Long,
    @SerializedName("page_number")
    val pageNumber: Long,
    val items: List<ItemDto>,
    val breadcrumbs: List<BreadcrumbDto>,
    @SerializedName("section_id")
    val sectionId: Long,
    @SerializedName("section_1c_code")
    val section1cCode: String,
    @SerializedName("section_description")
    val sectionDescription: String,
    val index: Boolean,
    @SerializedName("meta_tags")
    val metaTags: MetaTagsDto,
    val header: String,
)