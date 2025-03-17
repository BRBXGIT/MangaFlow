package com.example.mangaflow.core.data.network.ktor

import androidx.collection.intFloatMapOf
import com.example.mangaflow.core.data.network.models.manga_chapters_response.MangaChaptersResponse
import com.example.mangaflow.core.data.network.models.manga_details_response.MangaDetailsResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result
import com.example.mangaflow.core.data.network.utils.Utils
import com.example.mangaflow.core.data.network.utils.processNetworkErrors
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import java.rmi.server.ServerCloneException

class MangaDetailsScreenKtorClient(
    private val httpClient: HttpClient
) {
    suspend fun getMangaDetails(
        id: String
    ): Result<MangaDetailsResponse, NetworkError> {
        val response = try {
            httpClient.get(urlString = "${Utils.BASE_URL}/manga/$id?" +
                    "includes[]=cover_art&" +
                    "includes[]=author&" +
                    "includes[]=translatedLanguage"
            )
        } catch(e: kotlinx.io.IOException) { //Use IOException cause UnresolvedAddressException doesn't work
            return Result.Error(NetworkError.NO_INTERNET)
        } catch(e: ServerCloneException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return if(response.status.value in 200..299) {
            Result.Success(response.body<MangaDetailsResponse>())
        } else {
            processNetworkErrors(response.status.value)
        }
    }

    suspend fun getMangaChapters(
        mangaId: String,
        translatedLanguage: String,
        offset: Int,
        limit: Int,
        scanlationGroupId: String? = null
    ): Result<MangaChaptersResponse, NetworkError> {
        val response = try {
            httpClient.get(
                urlString = "${Utils.BASE_URL}chapter?" +
                        "manga=$mangaId&" +
                        "translatedLanguage[]=$translatedLanguage&" +
                        "offset=$offset&" +
                        "limit=$limit&" +
                        "order[chapter]=asc&" +
                        "includes[]=scanlation_group&" +
                        if(scanlationGroupId != null) "groups[]=$scanlationGroupId" else ""
            )
        } catch(e: kotlinx.io.IOException) { //Use IOException cause UnresolvedAddressException doesn't work
            return Result.Error(NetworkError.NO_INTERNET)
        } catch(e: ServerCloneException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return if(response.status.value in 200..299) {
            Result.Success(response.body<MangaChaptersResponse>())
        } else {
            processNetworkErrors(response.status.value)
        }
    }
}