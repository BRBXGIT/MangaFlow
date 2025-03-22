package com.example.mangaflow.feature.auth_screen.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaflow.common.functions.processNetworkErrorsForUi
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

    private val _accessToken = MutableStateFlow<String?>(null)
    val accessToken = _accessToken.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        null
    )

    fun fetchUserAccessToken(
        userName: String,
        password: String
    ) {
        viewModelScope.launch(dispatcherIo) {
            val response = repository.getUserAccessToken(userName, password)
            response.onError { error ->
                SnackbarController.sendEvent(
                    SnackbarEvent(
                        message = processNetworkErrorsForUi(error),
                        action = SnackbarAction(
                            name = "Refresh",
                            action = { fetchUserAccessToken(userName, password) }
                        )
                    )
                )
            }
            response.onSuccess { data ->
                _accessToken.value = data.accessToken
            }
        }
    }
}