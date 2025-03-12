package com.example.mangaflow.core.data.repositories

import com.example.mangaflow.core.data.network.ktor.MangaDetailsScreenKtorClient
import com.example.mangaflow.core.data.network.models.manga_chapters_response.MangaChaptersResponse
import com.example.mangaflow.core.data.network.models.manga_details_response.MangaDetailsResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result
import com.example.mangaflow.core.repositories.MangaDetailsScreenRepo

class MangaDetailsScreenRepoImpl(
    private val ktorClient: MangaDetailsScreenKtorClient
): MangaDetailsScreenRepo {

    override suspend fun getMangaDetails(mangaId: String): Result<MangaDetailsResponse, NetworkError> {
        return ktorClient.getMangaDetails(mangaId)
    }

    override suspend fun getMangaChapters(
        mangaId: String,
        translatedLanguage: String,
        offset: Int,
        limit: Int
    ): Result<MangaChaptersResponse, NetworkError> {
        return ktorClient.getMangaChapters(mangaId, translatedLanguage, offset, limit)
    }
}