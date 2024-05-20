package com.example.mechtatestassignment.data.remote.dto.itemDetailsDto

import com.google.gson.annotations.SerializedName

data class Properties(
    @SerializedName("241")
    val n241: Property,
    @SerializedName("261")
    val n261: Property,
    @SerializedName("249")
    val n249: Property,
    @SerializedName("260")
    val n260: Property,
    @SerializedName("263")
    val n263: Property,
    @SerializedName("264")
    val n264: Property,
    @SerializedName("253")
    val n253: Property,
    @SerializedName("362")
    val n362: Property,
    @SerializedName("388")
    val n388: Property,
    @SerializedName("258")
    val n258: Property,
    @SerializedName("269")
    val n269: Property,
    @SerializedName("244")
    val n244: Property,
    @SerializedName("245")
    val n245: Property,
    @SerializedName("247")
    val n247: Property,
    @SerializedName("262")
    val n262: Property,
    @SerializedName("267")
    val n267: Property,
    @SerializedName("255")
    val n255: Property,
    @SerializedName("265")
    val n265: Property,
    @SerializedName("243")
    val n243: Property,
    @SerializedName("246")
    val n246: Property,
)

data class Property(
    @SerializedName("prop_group_name")
    val propGroupName: String,
    @SerializedName("prop_group_sort")
    val propGroupSort: Long,
    val values: List<PropertyValue>,
)

data class PropertyValue(
    @SerializedName("prop_id")
    val propId: Long,
    @SerializedName("prop_name")
    val propName: String,
    @SerializedName("prop_name_description")
    val propNameDescription: String,
    @SerializedName("prop_name_id")
    val propNameId: Long,
    @SerializedName("prop_value")
    val propValue: String,
    @SerializedName("prop_xml_id")
    val propXmlId: String,
    val code: String,
    val section: Any?,
)