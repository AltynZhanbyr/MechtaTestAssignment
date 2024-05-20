package com.example.mechtatestassignment.data.mapper

import com.example.mechtatestassignment.data.remote.dto.itemDetailsDto.DataDetailsDto
import com.example.mechtatestassignment.data.remote.dto.itemDetailsDto.MainPropertyDto
import com.example.mechtatestassignment.data.remote.dto.itemListDto.ItemDto
import com.example.mechtatestassignment.domain.model.Item
import com.example.mechtatestassignment.domain.model.ItemDetails
import com.example.mechtatestassignment.domain.model.MainProperty

fun ItemDto.toModel() = Item(
    id = id,
    name = name,
    photos = photos,
    price = price,
    code = code
)

fun MainPropertyDto.toModel() = MainProperty(
    propName = propName,
    propValue = propValue
)

fun DataDetailsDto.toModel() = ItemDetails(
    id = id,
    name = name,
    photos = photos,
    price = price,
    code = code,
    properties = mainProperties.map { dto ->
        dto.toModel()
    }
)





