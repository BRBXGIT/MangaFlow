package com.example.mangaflow.core.data.local

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class MangaFlowUserDbProvider(
    private val context: Context
) {
    actual fun provideMangaFlowUserDb(): MangaFlowUserDb {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath("manga_flow_user_db.db")
        return Room.databaseBuilder<MangaFlowUserDb>(
            context = appContext,
            name = dbFile.absolutePath
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}