package com.example.mangaflow.app

import android.app.Application
import com.example.mangaflow.di.initKoin
import org.koin.android.ext.koin.androidContext

class KoinApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@KoinApp)
        }
    }
}