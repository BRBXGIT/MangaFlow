package com.example.mangaflow.feature.auth_screen.screen.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaflow.common.functions.processNetworkErrorsForUi
import com.example.mangaflow.core.data.local.manga_flow_user_db.MangaFlowUser
import com.example.mangaflow.core.data.network.utils.onError
import com.example.mangaflow.core.data.network.utils.onSuccess
import com.example.mangaflow.core.design_system.snackbars.SnackbarAction
import com.example.mangaflow.core.design_system.snackbars.SnackbarController
import com.example.mangaflow.core.design_system.snackbars.SnackbarEvent
import com.example.mangaflow.core.repositories.AuthScreenRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AuthScreenVM(
    private val repository: AuthScreenRepo,
    private val dispatcherIo: CoroutineDispatcher
): ViewModel() {

    fun fetchUserAccessToken(
        userName: String,
        password: String,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch(dispatcherIo) {
            val response = repository.getUserAccessToken(userName, password)
            response.onError { error ->
                SnackbarController.sendEvent(
                    SnackbarEvent(
                        message = processNetworkErrorsForUi(error),
                        action = SnackbarAction(
                            name = "Try again",
                            action = { fetchUserAccessToken(userName, password, onSuccess) }
                        )
                    )
                )
            }
            response.onSuccess { data ->
                repository.upsertMangaFlowUser(
                    MangaFlowUser(
                        accessToken = data.accessToken,
                        refreshToken = data.refreshToken
                    )
                )
                repository.setIsAuthenticatedKey(true)
                onSuccess()
            }
        }
    }
}