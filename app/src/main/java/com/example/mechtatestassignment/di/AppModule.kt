package com.example.mechtatestassignment.di

import com.example.mechtatestassignment.data.remote.RemoteRepositoryImpl
import com.example.mechtatestassignment.data.remote.adapter.SameProductClassTypeAdapter
import com.example.mechtatestassignment.data.remote.adapter.StickersClassTypeAdapter
import com.example.mechtatestassignment.data.remote.api.MechtaApi
import com.example.mechtatestassignment.data.remote.dto.itemDetailsDto.SameProducts
import com.example.mechtatestassignment.data.remote.dto.itemDetailsDto.Stickers
import com.example.mechtatestassignment.domain.repository.RemoteRepository
import com.example.mechtatestassignment.domain.useCase.GetSmartphoneDetailsUseCase
import com.example.mechtatestassignment.domain.useCase.GetSmartphonesUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import kotlin.coroutines.CoroutineContext


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

    single<CoroutineContext> { Dispatchers.IO }

    factory<RemoteRepository> {
        RemoteRepositoryImpl(get())
    }

    factoryOf(::GetSmartphonesUseCase)
    factoryOf(::GetSmartphoneDetailsUseCase)
}