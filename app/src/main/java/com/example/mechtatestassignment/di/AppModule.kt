package com.example.mechtatestassignment.di

import com.example.mechtatestassignment.data.remote.RemoteRepositoryImpl
import com.example.mechtatestassignment.data.remote.api.MechtaApi
import com.example.mechtatestassignment.domain.repository.RemoteRepository
import com.example.mechtatestassignment.domain.useCase.GetSmartphonesUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext


val appModule = module {
    single<MechtaApi> {
        Retrofit.Builder()
            .baseUrl("https://www.mechta.kz/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MechtaApi::class.java)
    }

    single<CoroutineContext> { Dispatchers.IO }

    factory<RemoteRepository> {
        RemoteRepositoryImpl(get())
    }

    factoryOf(::GetSmartphonesUseCase)
}