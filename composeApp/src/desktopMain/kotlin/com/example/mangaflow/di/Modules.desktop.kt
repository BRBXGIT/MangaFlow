package com.example.mangaflow.di

import com.example.mangaflow.core.data.local.MangaFlowUserDbProvider
import com.example.mangaflow.core.data.network.ktor.AuthScreensKtorClient
import com.example.mangaflow.core.data.network.ktor.createHttpClient
import com.example.mangaflow.core.data.repositories.AuthScreenRepoImpl
import com.example.mangaflow.core.repositories.AuthScreenRepo
import com.example.mangaflow.feature.auth_screen.screen.common.AuthScreenVM
import io.ktor.client.engine.okhttp.OkHttp
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
    singleOf(::MangaFlowUserDbProvider)
    singleOf(::AuthScreenRepoImpl).bind<AuthScreenRepo>()
    viewModelOf(::AuthScreenVM)
}