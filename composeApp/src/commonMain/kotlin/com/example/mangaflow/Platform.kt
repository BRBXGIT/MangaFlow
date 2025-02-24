package com.example.mangaflow

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform