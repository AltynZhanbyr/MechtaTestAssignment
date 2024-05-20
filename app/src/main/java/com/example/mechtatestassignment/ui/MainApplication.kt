package com.example.mechtatestassignment.ui

import android.app.Application
import com.example.mechtatestassignment.di.appModule
import com.example.mechtatestassignment.di.screenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                appModule,
                screenModule
            )
        }
    }
}