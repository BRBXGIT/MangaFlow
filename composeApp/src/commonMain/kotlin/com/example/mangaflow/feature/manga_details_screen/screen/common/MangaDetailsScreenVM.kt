package com.example.mangaflow.feature.manga_details_screen.screen.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaflow.common.functions.processNetworkErrorsForUi
import com.example.mangaflow.core.data.network.models.manga_details_response.Data as MangaDetailsData
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

class MangaDetailsScreenVM(
    private val repository: MangaDetailsScreenRepo,
    private val dispatcherIo: CoroutineDispatcher
): ViewModel() {
    private val _mangaDetails = MutableStateFlow<MangaDetailsData?>(null)
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
}