package com.kishorejethava.simplemusicplayer.injections

import com.kishorejethava.simplemusicplayer.storage.database.MusicDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {
    // Dependency: AppDatabase
    single {
        MusicDatabase.getInstance(androidContext())
    }

    // App Dao Dependency:
    single {
        val appDatabase: MusicDatabase = get()
        appDatabase.songDao()
    }
}