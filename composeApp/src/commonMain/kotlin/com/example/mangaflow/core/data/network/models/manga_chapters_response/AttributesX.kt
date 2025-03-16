package com.example.mangaflow.core.data.network.models.manga_chapters_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AttributesX(
    @SerialName("altNames")
    val altNames: List<AltName> = listOf(),
    @SerialName("contactEmail")
    val contactEmail: String? = null,
    @SerialName("createdAt")
    val createdAt: String = "",
    @SerialName("description")
    val description: String? = null,
    @SerialName("discord")
    val discord: String? = null,
    @SerialName("focusedLanguages")
    val focusedLanguages: List<String> = listOf(),
    @SerialName("inactive")
    val inactive: Boolean = false,
    @SerialName("ircChannel")
    val ircChannel: String? = null,
    @SerialName("ircServer")
    val ircServer: String? = null,
    @SerialName("locked")
    val locked: Boolean = false,
    @SerialName("mangaUpdates")
    val mangaUpdates: String? = null,
    @SerialName("name")
    val name: String = "",
    @SerialName("official")
    val official: Boolean = false,
    @SerialName("publishDelay")
    val publishDelay: String? = null,
    @SerialName("twitter")
    val twitter: String? = null,
    @SerialName("updatedAt")
    val updatedAt: String = "",
    @SerialName("verified")
    val verified: Boolean = false,
    @SerialName("version")
    val version: Int = 0,
    @SerialName("website")
    val website: String = ""
)