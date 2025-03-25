package com.example.mangaflow.core.data.repositories

import com.example.mangaflow.core.data.local.manga_flow_user_db.MangaFlowUser
import com.example.mangaflow.core.data.local.manga_flow_user_db.MangaFlowUserDb
import com.example.mangaflow.core.data.local.shared_prefs.UserPreferences
import com.example.mangaflow.core.data.network.ktor.AuthScreensKtorClient
import com.example.mangaflow.core.data.network.models.user_access_token_response.UserAccessTokenResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result
import com.example.mangaflow.core.repositories.AuthScreenRepo
import kotlinx.coroutines.flow.Flow

class AuthScreenRepoImpl(
    private val ktorClient: AuthScreensKtorClient,
    private val mangaFlowUserDb: MangaFlowUserDb,
    private val userPreferences: UserPreferences
): AuthScreenRepo {

    override suspend fun getUserAccessToken(
        userName: String,
        password: String
    ): Result<UserAccessTokenResponse, NetworkError> {
        return ktorClient.getUserAccessToken(userName, password)
    }

    override suspend fun upsertMangaFlowUser(user: MangaFlowUser) {
        mangaFlowUserDb.mangaFlowUserDao().upsertMangaFlowUser(user)
    }

    override fun getMangaFlowUser(): Flow<List<MangaFlowUser>> {
        return mangaFlowUserDb.mangaFlowUserDao().getMangaFlowUser()
    }

    override fun setIsAuthenticatedKey(isAuthenticated: Boolean) {
        userPreferences.setUserRegistered(isAuthenticated)
    }
}