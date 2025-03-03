package com.example.mangaflow.core.data.network.ktor

import com.example.mangaflow.core.data.network.models.all_manga_response.AllMangaResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result
import com.example.mangaflow.core.data.network.utils.Utils
import com.example.mangaflow.core.data.network.utils.processNetworkErrors
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import java.rmi.server.ServerCloneException

class MangaScreenKtorClient(
    private val httpClient: HttpClient
) {
    suspend fun getMangaByTitle(
        title: String?,
        offset: Int,
        limit: Int
    ): Result<AllMangaResponse, NetworkError> {
        val response = try {
            httpClient.get(
                urlString = if(title != null) "${Utils.BASE_URL}/manga?" +
                        "title=$title&" +
                        "limit=$limit&" +
                        "offset=$offset&" +
                        "includes[]=cover_art&" +
                        "includes[]=genres&" +
                        "order[followedCount]=desc"
                else "${Utils.BASE_URL}/manga?" +
                        "limit=$limit&" +
                        "offset=$offset&" +
                        "includes[]=cover_art&" +
                        "includes[]=genres&" +
                        "order[followedCount]=desc"
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