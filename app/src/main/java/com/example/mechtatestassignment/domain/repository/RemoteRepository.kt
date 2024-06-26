package com.example.mechtatestassignment.domain.repository

import com.example.mechtatestassignment.data.remote.dto.itemDetailsDto.DataDetailsDto
import com.example.mechtatestassignment.data.remote.dto.itemListDto.DataListDto
import com.example.mechtatestassignment.data.remote.model.Response

interface RemoteRepository {
    suspend fun getSmartphones(
        page: Int,
        limit: Int
    ): Response<DataListDto>

    suspend fun getSmartphoneDetails(
        code: String
    ): Response<DataDetailsDto>
}