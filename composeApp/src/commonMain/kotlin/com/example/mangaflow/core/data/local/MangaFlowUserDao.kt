package com.example.mangaflow.core.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MangaFlowUserDao {

    @Query("SELECT * FROM MangaFlowUser")
    suspend fun getMangaFlowUser(): Flow<List<MangaFlowUser>>

    @Upsert
    suspend fun upsertMangaFlowUser(user: MangaFlowUser)

    @Delete
    suspend fun deleteMangaFlowUser(user: MangaFlowUser)
}