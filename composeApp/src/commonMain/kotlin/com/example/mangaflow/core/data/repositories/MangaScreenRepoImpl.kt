package com.example.mangaflow.core.data.repositories

import com.example.mangaflow.core.data.network.ktor.KtorClient
import com.example.mangaflow.core.data.network.models.all_manga.AllMangaResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result
import com.example.mangaflow.core.repositories.MangaScreenRepo

class MangaScreenRepoImpl(
    private val ktorClient: KtorClient
): MangaScreenRepo {

    override suspend fun getMangaByTitle(
        title: String?,
        offset: Int,
        limit: Int
    ): Result<AllMangaResponse, NetworkError> {
        return ktorClient.getMangaByTitle(title, offset, limit)
    }
}