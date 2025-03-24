package com.example.mangaflow.core.repositories

import com.example.mangaflow.core.data.local.MangaFlowUser
import com.example.mangaflow.core.data.network.models.user_access_token_response.UserAccessTokenResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result
import kotlinx.coroutines.flow.Flow

interface AuthScreenRepo {

    suspend fun getUserAccessToken(
        userName: String,
        password: String
    ): Result<UserAccessTokenResponse, NetworkError>

    suspend fun upsertMangaFlowUser(user: MangaFlowUser)

    fun getMangaFlowUser(): Flow<List<MangaFlowUser>>
}