package com.example.mangaflow.core.data.local

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class MangaFlowUserDbProvider {
    fun provideMangaFlowUserDb(): MangaFlowUserDb
}