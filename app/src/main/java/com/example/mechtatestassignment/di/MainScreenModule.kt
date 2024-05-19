package com.example.mechtatestassignment.di

import com.example.mechtatestassignment.ui.screen.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val mainScreenModule = module{
    viewModelOf(::MainViewModel)
}