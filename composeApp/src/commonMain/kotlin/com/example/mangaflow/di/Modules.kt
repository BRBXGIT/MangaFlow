package com.example.mangaflow.di

import com.example.mangaflow.core.data.network.ktor.KtorClient
import com.example.mangaflow.core.data.network.ktor.createHttpClient
import com.example.mangaflow.core.data.repositories.MangaScreenRepoImpl
import com.example.mangaflow.core.repositories.MangaScreenRepo
import com.example.mangaflow.feature.manga_screen.screen.MangaScreenVM
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.Dispatchers
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dispatchersModule = module {
    single {
        Dispatchers.IO
    }
}

val sharedModule = module {
    single {
        KtorClient(
            createHttpClient(
                OkHttp.create()
            )
        )
    }
    singleOf(::MangaScreenRepoImpl).bind<MangaScreenRepo>()
    viewModelOf(::MangaScreenVM)
}