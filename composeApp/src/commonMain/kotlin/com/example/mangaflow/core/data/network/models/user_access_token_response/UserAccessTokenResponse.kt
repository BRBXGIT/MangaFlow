package com.example.mangaflow.core.data.network.models.user_access_token_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserAccessTokenResponse(
    @SerialName("access_token")
    val accessToken: String = "",
    @SerialName("refresh_token")
    val refreshToken: String = ""
)