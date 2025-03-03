package com.example.mangaflow.core.repositories

import com.example.mangaflow.core.data.network.models.manga_details_response.MangaDetailsResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result

interface MangaDetailsScreenRepo {

    suspend fun getMangaDetails(mangaId: String): Result<MangaDetailsResponse, NetworkError>
}