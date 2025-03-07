package com.example.mangaflow.core.data.repositories

import com.example.mangaflow.core.data.network.ktor.HomeScreenKtorClient
import com.example.mangaflow.core.data.network.models.all_manga_response.AllMangaResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result
import com.example.mangaflow.core.repositories.HomeScreenRepo

class HomeScreenRepoImpl(
    private val ktorClient: HomeScreenKtorClient
): HomeScreenRepo {

    override suspend fun getMangaByTitle(
        title: String?,
        offset: Int,
        limit: Int
    ): Result<AllMangaResponse, NetworkError> {
        return ktorClient.getMangaByTitle(title, offset, limit)
    }
}