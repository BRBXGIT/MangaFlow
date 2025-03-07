package com.example.mangaflow.di

import com.example.mangaflow.core.data.network.ktor.MangaDetailsScreenKtorClient
import com.example.mangaflow.core.data.network.ktor.HomeScreenKtorClient
import com.example.mangaflow.core.data.network.ktor.createHttpClient
import com.example.mangaflow.core.data.repositories.MangaDetailsScreenRepoImpl
import com.example.mangaflow.core.data.repositories.HomeScreenRepoImpl
import com.example.mangaflow.core.repositories.MangaDetailsScreenRepo
import com.example.mangaflow.core.repositories.HomeScreenRepo
import com.example.mangaflow.feature.home_screen.screen.HomeScreenVM
import com.example.mangaflow.feature.manga_details_screen.screen.common.MangaDetailsScreenVM
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

val homeScreenModule = module {
    single {
        HomeScreenKtorClient(
            createHttpClient(
                OkHttp.create()
            )
        )
    }
    singleOf(::HomeScreenRepoImpl).bind<HomeScreenRepo>()
    viewModelOf(::HomeScreenVM)
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