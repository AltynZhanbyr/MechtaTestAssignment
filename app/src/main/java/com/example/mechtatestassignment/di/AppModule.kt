package com.example.mechtatestassignment.di

import com.example.mechtatestassignment.data.remote.RemoteRepositoryImpl
import com.example.mechtatestassignment.data.remote.adapter.SameProductClassTypeAdapter
import com.example.mechtatestassignment.data.remote.adapter.StickersClassTypeAdapter
import com.example.mechtatestassignment.data.remote.api.MechtaApi
import com.example.mechtatestassignment.data.remote.dto.itemDetailsDto.SameProducts
import com.example.mechtatestassignment.data.remote.dto.itemDetailsDto.Stickers
import com.example.mechtatestassignment.domain.repository.RemoteRepository
import com.example.mechtatestassignment.util.AppPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type


val appModule = module {
    factory<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    factory<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()

    }

    factory<RemoteRepository> {
        RemoteRepositoryImpl(get())
    }

    single<Gson> {
        val stickersClassType: Type = object : TypeToken<List<Stickers?>?>() {}.type
        val sameProductsClassType: Type = object : TypeToken<List<SameProducts?>?>() {}.type

        GsonBuilder()
            .registerTypeAdapter(stickersClassType, StickersClassTypeAdapter())
            .registerTypeAdapter(sameProductsClassType, SameProductClassTypeAdapter())
            .create()
    }

    single<MechtaApi> {
        Retrofit.Builder()
            .baseUrl("https://www.mechta.kz/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
            .create(MechtaApi::class.java)
    }

    single<AppPreferences> {
        AppPreferences(androidApplication())
    }

}