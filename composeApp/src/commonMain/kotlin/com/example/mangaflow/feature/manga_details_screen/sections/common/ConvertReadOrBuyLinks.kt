package com.example.mangaflow.feature.manga_details_screen.sections.common

import com.example.mangaflow.core.data.network.models.manga_details_response.Links as MangaDetailsResponseLinks

data class MangaLink(
    val name: String,
    val link: String
)

fun convertReadOrBuyLinks(
    links: MangaDetailsResponseLinks
): List<MangaLink> {
    val readOrBuyConvertedLinks = mutableListOf<MangaLink>()
    if(links.raw != "") {
        readOrBuyConvertedLinks += MangaLink("Official Raw", "https://page.kakao.com/home?seriesId=${links.raw}")
    }
    if(links.engTl != "") {
        readOrBuyConvertedLinks += MangaLink("Official English", links.engTl)
    }
    if(links.bw != "") {
        readOrBuyConvertedLinks += MangaLink("Book Walker", "https://bookwalker.jp/${links.bw}")
    }
    if(links.amz != "") {
        readOrBuyConvertedLinks += MangaLink("Amazon", links.amz)
    }
    if(links.ebj != "") {
        readOrBuyConvertedLinks += MangaLink("eBookJapan", links.ebj)
    }

    return readOrBuyConvertedLinks
}

fun convertTrackLinks(
    links: MangaDetailsResponseLinks
): List<MangaLink> {
    val trackConvertedLinks = mutableListOf<MangaLink>()
    if(links.mu != "") {
        trackConvertedLinks += MangaLink("MangaUpdates", "https://www.mangaupdates.com/series.html?id=${links.mu}")
    }
    if(links.ap != "") {
        trackConvertedLinks += MangaLink("Anime-Planet", "https://www.anime-planet.com/manga/${links.ap}")
    }
    if(links.al != "") {
        trackConvertedLinks += MangaLink("AniList", "https://anilist.co/manga/${links.al}")
    }
    if(links.kt != "") {
        trackConvertedLinks += MangaLink("Kitsu", "https://kitsu.io/manga/${links.kt}")
    }
    if(links.mal != "") {
        trackConvertedLinks += MangaLink("MyAnimeList", "https://myanimelist.net/manga/${links.mal}")
    }
    if(links.nu != "") {
        trackConvertedLinks += MangaLink("NovelUpdates", "https://www.novelupdates.com/series/${links.nu}")
    }

    return trackConvertedLinks
}