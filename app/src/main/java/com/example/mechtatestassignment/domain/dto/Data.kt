package com.example.mechtatestassignment.domain.dto

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("section_list")
    val sectionList: List<SectionDto> = emptyList(),
    @SerializedName("all_items_count")
    val allItemsCount: Int? = null,
    @SerializedName("page_items_count")
    val pageItemsCount: Int? = null,
    @SerializedName("page_number")
    val pageNumber: Int? = null,
    val items: List<ItemDto> = emptyList(),
    val breadcrumbs: List<Breadcrumbs> = emptyList(),
    @SerializedName("section_id")
    val sectionId: Int? = null,
    @SerializedName("section_1c_code")
    val section1cCode: String? = null,
    @SerializedName("section_description")
    val sectionDescription: String? = null,
    val index: Boolean? = null,
    @SerializedName("meta_tags")
    val metaTags: MetaTagsDto? = null,
    val header: String? = null
)
