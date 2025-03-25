package com.example.mangaflow.di

import com.example.mangaflow.core.data.local.manga_flow_user_db.MangaFlowUserDbProvider
import com.example.mangaflow.core.data.local.shared_prefs.SettingsProvider
import com.example.mangaflow.core.data.local.shared_prefs.UserPreferences
import com.example.mangaflow.core.data.network.ktor.AuthScreensKtorClient
import com.example.mangaflow.core.data.network.ktor.createHttpClient
import com.example.mangaflow.core.data.repositories.AuthScreenRepoImpl
import com.example.mangaflow.core.repositories.AuthScreenRepo
import com.example.mangaflow.feature.auth_screen.screen.common.AuthScreenVM
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.android.ext.koin.androidContext
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val authScreenModule = module {
    single {
        AuthScreensKtorClient(
            createHttpClient(
                OkHttp.create()
            )
        )
    }
    single {
        MangaFlowUserDbProvider(androidContext()).provideMangaFlowUserDb()
    }
    single {
        UserPreferences(SettingsProvider(androidContext()).provideSettings())
    }
    singleOf(::AuthScreenRepoImpl).bind<AuthScreenRepo>()
    viewModelOf(::AuthScreenVM)
}