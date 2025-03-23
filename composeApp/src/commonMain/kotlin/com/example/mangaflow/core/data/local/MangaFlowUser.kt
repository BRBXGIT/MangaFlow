package com.example.mangaflow.core.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MangaFlowUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val accessToken: String,
    val refreshToken: String
)
