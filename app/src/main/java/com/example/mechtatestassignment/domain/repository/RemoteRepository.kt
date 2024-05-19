package com.example.mechtatestassignment.domain.repository

import com.example.mechtatestassignment.data.remote.dto.Data
import com.example.mechtatestassignment.data.remote.model.Response

interface RemoteRepository {
    suspend fun getSmartphones(
        page: Int,
        limit: Int,
        selection: String
    ): Response<Data>
}