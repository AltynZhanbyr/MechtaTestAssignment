package com.example.mechtatestassignment.data.remote

import com.example.mechtatestassignment.data.remote.api.MechtaApi
import com.example.mechtatestassignment.data.remote.dto.Data
import com.example.mechtatestassignment.data.remote.model.Response
import com.example.mechtatestassignment.domain.repository.RemoteRepository

class RemoteRepositoryImpl(
    private val mechtaApi: MechtaApi
) : RemoteRepository {
    override suspend fun getSmartphones(
        page: Int,
        limit: Int
    ): Response<Data> = mechtaApi.getSmartphones(page, limit)
}