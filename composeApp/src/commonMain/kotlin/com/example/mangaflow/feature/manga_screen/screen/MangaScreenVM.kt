package com.example.mangaflow.feature.manga_screen.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaflow.core.data.network.models.all_manga.AllMangaResponse
import com.example.mangaflow.core.repositories.MangaScreenRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class MangaScreenVM(
    private val repository: MangaScreenRepo,
    private val ioDispatcher: CoroutineDispatcher
): ViewModel() {
    private val _allManga = MutableStateFlow<AllMangaResponse?>(null)
    val allManga = _allManga.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        null
    )

    fun fetchAllManga() {

    }
}