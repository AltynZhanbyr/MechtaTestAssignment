package com.example.mechtatestassignment.data.mapper

import com.example.mechtatestassignment.data.remote.dto.ItemDto
import com.example.mechtatestassignment.domain.model.Item

fun ItemDto.toModel() = Item(
    id = id,
    name = name,
    photos = photos,
    price = price
)

