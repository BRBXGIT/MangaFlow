package com.example.mangaflow.core.data.network.models.manga_details_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AttributesXX(
    @SerialName("biography")
    val biography: Biography? = null,
    @SerialName("booth")
    val booth: String? = null,
    @SerialName("createdAt")
    val createdAt: String = "",
    @SerialName("description")
    val description: String? = null,
    @SerialName("fanBox")
    val fanBox: String? = null,
    @SerialName("fantia")
    val fantia: String? = null,
    @SerialName("fileName")
    val fileName: String? = null,
    @SerialName("imageUrl")
    val imageUrl: String? = null,
    @SerialName("locale")
    val locale: String? = null,
    @SerialName("melonBook")
    val melonBook: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("namicomi")
    val namicomi: String? = null,
    @SerialName("naver")
    val naver: String? = null,
    @SerialName("nicoVideo")
    val nicoVideo: String? = null,
    @SerialName("pixiv")
    val pixiv: String? = null,
    @SerialName("skeb")
    val skeb: String? = null,
    @SerialName("tumblr")
    val tumblr: String? = null,
    @SerialName("twitter")
    val twitter: String? = null,
    @SerialName("updatedAt")
    val updatedAt: String = "",
    @SerialName("version")
    val version: Int = 0,
    @SerialName("volume")
    val volume: String? = null,
    @SerialName("website")
    val website: String? = null,
    @SerialName("weibo")
    val weibo: String? = null,
    @SerialName("youtube")
    val youtube: String? = null
)