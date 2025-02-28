package com.example.mangaflow.feature.manga_screen.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaflow.core.data.network.utils.onError
import com.example.mangaflow.core.data.network.utils.onSuccess
import com.example.mangaflow.core.repositories.MangaScreenRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import com.example.mangaflow.core.data.network.models.all_manga.Data as MangaByTitleData

class MangaScreenVM(
    private val repository: MangaScreenRepo,
    private val dispatcherIo: CoroutineDispatcher
): ViewModel() {
    private val _allManga = MutableStateFlow<List<MangaByTitleData>>(emptyList())
    val allManga = _allManga.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        emptyList()
    )

    private val limit = 20
    private var offset = 0

    fun fetchAllManga() {
        viewModelScope.launch(dispatcherIo) {
            val response = repository.getMangaByTitle(offset = offset, limit = limit)
            response.onError { error ->
                println("TAG: ${error.name}") //TODO make normal extensions handling
            }
            response.onSuccess { data ->
                _allManga.value += data.data
                offset += limit
            }
        }
    }
}