package com.kishorejethava.simplemusicplayer.storage.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.kishorejethava.simplemusicplayer.storage.database.typeconverter.SongTypeConverter
import com.kishorejethava.simplemusicplayer.model.ResFeed

@Entity(tableName = "tbl_song_data")
data class SongTable(
    @PrimaryKey
    val page: Int = 1,

    @ColumnInfo(name = "song_response")
    @TypeConverters(SongTypeConverter::class)
    val results: ResFeed
)