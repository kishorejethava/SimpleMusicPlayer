package com.kishorejethava.simplemusicplayer.storage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kishorejethava.simplemusicplayer.storage.database.entity.SongTable
import com.kishorejethava.simplemusicplayer.storage.database.dao.SongDao
import com.kishorejethava.simplemusicplayer.storage.database.typeconverter.SongTypeConverter

@Database(entities = [SongTable::class], version = 1)
@TypeConverters(SongTypeConverter::class)
abstract class MusicDatabase : RoomDatabase() {

    abstract fun songDao(): SongDao

    companion object {
        private const val DATABASE_NAME = "music-app"

        @Volatile
        private var INSTANCE: MusicDatabase? = null

        fun getInstance(context: Context): MusicDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MusicDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}