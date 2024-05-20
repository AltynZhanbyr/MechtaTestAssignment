package com.example.mechtatestassignment.data.remote.dto.itemDetailsDto

data class DeliveryInfoDto(
    val pickup: Pickup,
    val delivery: Delivery,
)

data class Pickup(
    val name: String,
    val text: String,
    val price: String,
)

data class Delivery(
    val city: City,
)

data class City(
    val days: String,
    val info: String,
    val text: String,
    val name: String,
    val price: String,
)