package com.example.mangaflow.core.data.local.manga_flow_user_db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MangaFlowUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val accessToken: String,
    val refreshToken: String
)