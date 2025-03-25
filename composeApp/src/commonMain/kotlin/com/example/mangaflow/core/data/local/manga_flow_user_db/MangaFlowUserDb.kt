package com.example.mangaflow.core.data.local.manga_flow_user_db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MangaFlowUser::class],
    version = 1,
)
@ConstructedBy(MangaFlowUserDbConstructor::class)
abstract class MangaFlowUserDb: RoomDatabase() {

    abstract fun mangaFlowUserDao(): MangaFlowUserDao
}