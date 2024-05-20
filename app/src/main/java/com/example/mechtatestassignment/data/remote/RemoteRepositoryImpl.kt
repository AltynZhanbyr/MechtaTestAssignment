package com.example.mechtatestassignment.data.remote

import com.example.mechtatestassignment.data.remote.api.MechtaApi
import com.example.mechtatestassignment.data.remote.dto.itemDetailsDto.DataDetailsDto
import com.example.mechtatestassignment.data.remote.dto.itemListDto.DataListDto
import com.example.mechtatestassignment.data.remote.model.Response
import com.example.mechtatestassignment.domain.repository.RemoteRepository

class RemoteRepositoryImpl(
    private val mechtaApi: MechtaApi
) : RemoteRepository {
    override suspend fun getSmartphones(
        page: Int,
        limit: Int
    ): Response<DataListDto> = mechtaApi.getSmartphones(page, limit)

    override suspend fun getSmartphoneDetails(
        code: String
    ): Response<DataDetailsDto> = mechtaApi.getSmartphoneDetails(code)
}