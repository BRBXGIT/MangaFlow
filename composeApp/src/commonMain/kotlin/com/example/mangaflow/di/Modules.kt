package com.example.mangaflow.di

import com.example.mangaflow.core.data.network.ktor.MangaDetailsScreenKtorClient
import com.example.mangaflow.core.data.network.ktor.MangaScreenKtorClient
import com.example.mangaflow.core.data.network.ktor.createHttpClient
import com.example.mangaflow.core.data.repositories.MangaDetailsScreenRepoImpl
import com.example.mangaflow.core.data.repositories.MangaScreenRepoImpl
import com.example.mangaflow.core.repositories.MangaDetailsScreenRepo
import com.example.mangaflow.core.repositories.MangaScreenRepo
import com.example.mangaflow.feature.home_screen.screen.MangaScreenVM
import com.example.mangaflow.feature.manga_details_screen.screen.MangaDetailsScreenVM
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.Dispatchers
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dispatchersModule = module {
    single {
        Dispatchers.IO
    }
}

val mangaScreenModule = module {
    single {
        MangaScreenKtorClient(
            createHttpClient(
                OkHttp.create()
            )
        )
    }
    singleOf(::MangaScreenRepoImpl).bind<MangaScreenRepo>()
    viewModelOf(::MangaScreenVM)
}

val mangaDetailsScreenModule = module {
    single {
        MangaDetailsScreenKtorClient(
            createHttpClient(
                OkHttp.create()
            )
        )
    }
    singleOf(::MangaDetailsScreenRepoImpl).bind<MangaDetailsScreenRepo>()
    viewModelOf(::MangaDetailsScreenVM)
}