package com.example.mangaflow.core.repositories

import com.example.mangaflow.core.data.network.models.user_access_token_response.UserAccessTokenResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result

interface AuthScreenRepo {

    suspend fun getUserAccessToken(
        userName: String,
        password: String
    ): Result<UserAccessTokenResponse, NetworkError>
}