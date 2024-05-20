package com.example.mechtatestassignment.di

import com.example.mechtatestassignment.data.remote.RemoteRepositoryImpl
import com.example.mechtatestassignment.data.remote.api.MechtaApi
import com.example.mechtatestassignment.domain.repository.RemoteRepository
import com.example.mechtatestassignment.domain.useCase.GetSmartphoneDetailsUseCase
import com.example.mechtatestassignment.domain.useCase.GetSmartphonesUseCase
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    single<MechtaApi> {
        Retrofit.Builder()
            .baseUrl("https://www.mechta.kz/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
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