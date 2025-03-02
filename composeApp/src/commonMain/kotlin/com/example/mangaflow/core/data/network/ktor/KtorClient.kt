package com.example.mangaflow.core.data.network.ktor

import com.example.mangaflow.core.data.network.models.all_manga.AllMangaResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import java.rmi.server.ServerCloneException

class KtorClient(
    private val httpClient: HttpClient
) {
    private fun processNetworkErrors(statusCode: Int): Result.Error<NetworkError> {
        return when(statusCode) {
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            409 -> Result.Error(NetworkError.CONFLICT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }

    private val baseUrl = "https://api.mangadex.org/"

    suspend fun getMangaByTitle(
        title: String?,
        offset: Int,
        limit: Int
    ): Result<AllMangaResponse, NetworkError> {
        val response = try {
            httpClient.get(
                urlString = if(title != null) "$baseUrl/manga?title=$title&limit=$limit&offset=$offset&includes[]=cover_art&includes[]=genres" else "$baseUrl/manga?limit=$limit&offset=$offset&includes[]=cover_art&includes[]=genres"
            )
        } catch(e: kotlinx.io.IOException) { //Use IOException cause UnresolvedAddressException doesn't work
            return Result.Error(NetworkError.NO_INTERNET)
        } catch(e: ServerCloneException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return if(response.status.value in 200..299) {
            Result.Success(response.body<AllMangaResponse>())
        } else {
            processNetworkErrors(response.status.value)
        }
    }
}