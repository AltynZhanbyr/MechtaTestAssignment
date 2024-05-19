package com.example.mechtatestassignment.data.remote.api

import com.example.mechtatestassignment.data.remote.model.Response
import com.example.mechtatestassignment.domain.dto.Data
import retrofit2.http.GET
import retrofit2.http.Query

interface MechtaApi {
    @GET("catalog?")
    suspend fun getSmartphones(
        @Query("page")
        page: Int,
        @Query("limit")
        limit: Int,
        @Query("section")
        selection: String
    ): Response<Data>
}