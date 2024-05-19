package com.example.mechtatestassignment.di

import com.example.mechtatestassignment.data.remote.api.MechtaApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    single<MechtaApi> {
        Retrofit.Builder()
            .baseUrl("https://www.mechta.kz/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MechtaApi::class.java)
    }
}