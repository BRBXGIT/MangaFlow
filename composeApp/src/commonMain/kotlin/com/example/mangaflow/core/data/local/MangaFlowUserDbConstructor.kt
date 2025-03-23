package com.example.mangaflow.core.data.local

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object MangaFlowUserDbConstructor : RoomDatabaseConstructor<MangaFlowUserDb> {
    override fun initialize(): MangaFlowUserDb
}