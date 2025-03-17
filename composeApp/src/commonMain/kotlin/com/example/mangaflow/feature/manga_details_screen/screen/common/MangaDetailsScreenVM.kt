package com.example.mangaflow.feature.manga_details_screen.screen.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaflow.common.functions.processNetworkErrorsForUi
import com.example.mangaflow.core.data.network.models.manga_chapters_response.Data as MangaChaptersResponseData
import com.example.mangaflow.core.data.network.utils.onError
import com.example.mangaflow.core.data.network.utils.onSuccess
import com.example.mangaflow.core.design_system.snackbars.SnackbarAction
import com.example.mangaflow.core.design_system.snackbars.SnackbarController
import com.example.mangaflow.core.design_system.snackbars.SnackbarEvent
import com.example.mangaflow.core.repositories.MangaDetailsScreenRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import com.example.mangaflow.core.data.network.models.manga_details_response.Data as MangaDetailsResponseData

data class TranslateGroup(
    val name: String,
    val id: String
)

class MangaDetailsScreenVM(
    private val repository: MangaDetailsScreenRepo,
    private val dispatcherIo: CoroutineDispatcher
): ViewModel() {
    private val _mangaDetails = MutableStateFlow<MangaDetailsResponseData?>(null)
    val mangaDetails = _mangaDetails.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        null
    )
    private val _mangaDetailsLoading = MutableStateFlow(true)
    val mangaDetailsLoading = _mangaDetailsLoading.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        true
    )

    fun fetchMangaDetails(mangaId: String) {
        viewModelScope.launch(dispatcherIo) {
            _mangaDetailsLoading.value = true
            val response = repository.getMangaDetails(mangaId)
            response.onError { error ->
                SnackbarController.sendEvent(
                    SnackbarEvent(
                        message = processNetworkErrorsForUi(error),
                        action = SnackbarAction(
                            name = "Refresh",
                            action = { fetchMangaDetails(mangaId) }
                        )
                    )
                )
            }
            response.onSuccess { data ->
                _mangaDetails.value = data.data
                _mangaDetailsLoading.value = false
            }
        }
    }


    private val _mangaChapters = MutableStateFlow<List<MangaChaptersResponseData>>(emptyList())
    val mangaChapters = _mangaChapters.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        emptyList()
    )
    private val _mangaChaptersLoading = MutableStateFlow(true)
    val mangaChaptersLoading = _mangaChaptersLoading.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        true
    )
    private val _mangaChaptersLanguage = MutableStateFlow<String?>(null)
    val mangaChaptersLanguage = _mangaChaptersLanguage.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        null
    )
    private val _mangaChaptersScanlationGroup = MutableStateFlow<TranslateGroup?>(null)
    val mangaChaptersScanlationGroup = _mangaChaptersScanlationGroup.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        null
    )

    private val limit = 20
    private var offset = 0

    fun setMangaChaptersLanguage(language: String) {
        _mangaChapters.value = emptyList()
        offset = 0
        _mangaChaptersLanguage.value = language
    }

    fun setMangaScanlationGroupId(
        name: String,
        id: String
    ) {
        _mangaChapters.value = emptyList()
        offset = 0
        _mangaChaptersScanlationGroup.value = TranslateGroup(name, id)
    }

    fun fetchMangaChapters(mangaId: String) {
        viewModelScope.launch(dispatcherIo) {
            _mangaChaptersLoading.value = true
            val response = if(_mangaChaptersScanlationGroup.value == null) {
                repository.getMangaChapters(mangaId, _mangaChaptersLanguage.value!!, offset, limit)
            } else {
                repository.getMangaChapters(mangaId, _mangaChaptersLanguage.value!!, offset, limit, _mangaChaptersScanlationGroup.value!!.id)
            }
            response.onError { error ->
                SnackbarController.sendEvent(
                    SnackbarEvent(
                        message = processNetworkErrorsForUi(error),
                        action = SnackbarAction(
                            name = "Refresh",
                            action = { fetchMangaChapters(mangaId) }
                        )
                    )
                )
            }
            response.onSuccess { data ->
                _mangaChapters.value += data.data
                _mangaChaptersLoading.value = false
                offset += limit
            }
        }
    }
}