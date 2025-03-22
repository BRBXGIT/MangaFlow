package com.example.mangaflow.core.data.network.ktor

import com.example.mangaflow.core.data.network.models.all_manga_response.AllMangaResponse
import com.example.mangaflow.core.data.network.models.user_access_token_response.UserAccessTokenResponse
import com.example.mangaflow.core.data.network.utils.NetworkError
import com.example.mangaflow.core.data.network.utils.Result
import com.example.mangaflow.core.data.network.utils.Utils
import com.example.mangaflow.core.data.network.utils.processNetworkErrors
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.Parameters
import java.rmi.server.ServerCloneException

class AuthScreensKtorClient(
    private val httpClient: HttpClient
) {
    suspend fun getUserAccessToken(
        userName: String,
        password: String
    ): Result<UserAccessTokenResponse, NetworkError> {
        val response = try {
            httpClient.post(
                urlString = "https://auth.mangadex.org/realms/mangadex/protocol/openid-connect/token",
            ) {
                setBody(
                    FormDataContent(
                        Parameters.build {
                            append("grant_type", "password")
                            append("username", userName)
                            append("password", password)
                            append("client_id", KtorUtils.CLIENT_ID)
                            append("client_secret", KtorUtils.CLIENT_SECRET)
                        }
                    )
                )
            }
        } catch(e: kotlinx.io.IOException) { //Use IOException cause UnresolvedAddressException doesn't work
            return Result.Error(NetworkError.NO_INTERNET)
        } catch(e: ServerCloneException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return if(response.status.value in 200..299) {
            Result.Success(response.body<UserAccessTokenResponse>())
        } else {
            processNetworkErrors(response.status.value)
        }
    }
}