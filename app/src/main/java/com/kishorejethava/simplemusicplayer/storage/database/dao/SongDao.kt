package com.kishorejethava.simplemusicplayer.storage.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kishorejethava.simplemusicplayer.model.ResFeed
import com.kishorejethava.simplemusicplayer.storage.database.entity.SongTable

@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSongs(movieResponse: SongTable)

    @Query("select * from tbl_song_data")
    fun getSongs(): SongTable?

}