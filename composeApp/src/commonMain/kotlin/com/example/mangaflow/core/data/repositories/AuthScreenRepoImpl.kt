package com.example.mangaflow.core.data.repositories

import com.example.mangaflow.core.data.network.ktor.AuthScreensKtorClient
import com.example.mangaflow.core.data.network.models.user_access_token_response.UserAccessTokenResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result
import com.example.mangaflow.core.repositories.AuthScreenRepo

class AuthScreenRepoImpl(
    private val ktorClient: AuthScreensKtorClient
): AuthScreenRepo {

    override suspend fun getUserAccessToken(
        userName: String,
        password: String
    ): Result<UserAccessTokenResponse, NetworkError> {
        return ktorClient.getUserAccessToken(userName, password)
    }
}