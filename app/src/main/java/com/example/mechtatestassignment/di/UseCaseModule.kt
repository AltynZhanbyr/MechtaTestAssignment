package com.example.mechtatestassignment.di

import com.example.mechtatestassignment.domain.useCase.GetSmartphoneDetailsUseCase
import com.example.mechtatestassignment.domain.useCase.GetSmartphonesUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::GetSmartphonesUseCase)
    factoryOf(::GetSmartphoneDetailsUseCase)
}