package com.example.mangaflow.core.repositories

import com.example.mangaflow.core.data.network.models.all_manga_response.AllMangaResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result

interface HomeScreenRepo {

    suspend fun getMangaByTitle(
        title: String? = null,
        offset: Int = 0,
        limit: Int = 20
    ): Result<AllMangaResponse, NetworkError>
}