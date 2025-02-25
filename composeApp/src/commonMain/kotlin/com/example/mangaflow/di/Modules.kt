package com.example.mangaflow.di

import com.example.mangaflow.core.data.repositories.MangaScreenRepoImpl
import com.example.mangaflow.core.repositories.MangaScreenRepo
import com.example.mangaflow.feature.manga_screen.MangaScreenVM
import kotlinx.coroutines.Dispatchers
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedDispatchersModule = module {
    single(
        named("IODispatcher")
    ) {
        Dispatchers.IO
    }
}

val sharedModule = module {
    singleOf(::MangaScreenRepoImpl).bind<MangaScreenRepo>()
    viewModelOf(::MangaScreenVM)
}