package com.example.mangaflow.core.repositories

import com.example.mangaflow.core.data.network.models.all_manga.AllMangaResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result

interface MangaScreenRepo {

    suspend fun getMangaByTitle(title: String?): Result<AllMangaResponse, NetworkError>
}