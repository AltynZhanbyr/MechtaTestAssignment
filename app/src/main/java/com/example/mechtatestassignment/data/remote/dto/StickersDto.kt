package com.example.mechtatestassignment.data.remote.dto

import com.google.gson.annotations.SerializedName

data class StickersDto(
    @SerializedName("trade-in-aktsiya")
    val tradeIn: TradeInDto,
    @SerializedName("delivery-express")
    val deliveryExpress: DeliveryExpressDto,
)