package com.example.mechtatestassignment.data.remote.api

import com.example.mechtatestassignment.data.remote.dto.itemListDto.DataListDto
import com.example.mechtatestassignment.data.remote.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MechtaApi {
    @GET("catalog?section=smartfony")
    suspend fun getSmartphones(
        @Query("page")
        page: Int,
        @Query("page_limit")
        limit: Int
    ): Response<DataListDto>
}