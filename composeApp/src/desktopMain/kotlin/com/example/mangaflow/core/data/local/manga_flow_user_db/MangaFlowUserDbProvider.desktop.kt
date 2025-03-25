package com.example.mangaflow.core.data.local.manga_flow_user_db

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class MangaFlowUserDbProvider {
    actual fun provideMangaFlowUserDb(): MangaFlowUserDb {
        val dbFile = File(System.getProperty("java.io.tmpdir"), "manga_flow_user_db.db")
        return Room.databaseBuilder<MangaFlowUserDb>(
            name = dbFile.absolutePath,
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}