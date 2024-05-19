package com.example.mechtatestassignment.domain.repository

import com.example.mechtatestassignment.data.remote.model.Response
import com.example.mechtatestassignment.domain.dto.Data

interface RemoteRepository {
    suspend fun getSmartphones(
        page: Int,
        limit: Int,
        selection: String
    ): Response<Data>
}