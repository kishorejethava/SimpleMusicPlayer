package com.kishorejethava.simplemusicplayer.model

import com.kishorejethava.simplemusicplayer.base.AppRepository
import com.kishorejethava.simplemusicplayer.storage.database.dao.SongDao
import com.kishorejethava.simplemusicplayer.storage.database.entity.SongTable
import com.kishorejethava.simplemusicplayer.utils.Constants.SOMETHING_WENT_WRONG
import com.kishorejethava.simplemusicplayer.wscoroutines.ApiInterface

class SongsRepositoryImpl constructor(
    private val songDao: SongDao,
    private val apiServiceInterface: ApiInterface
) : AppRepository(), SongsRepository {

    override suspend fun fetchSongs(
        onSuccess: (ResFeed) -> Unit,
        onError: (String) -> Unit
    ) {
        val result = safeApiCall(call = { apiServiceInterface.getSongsAsync().await() })
        if (result is ResFeed) {
            Thread {
                val songTable = SongTable(results = result)
                songDao.insertSongs(songTable)
                onSuccess(result)
            }.start()
        }
    }

    override fun getSongsLocal(onSuccess: (ResFeed?) -> Unit, onError: (String) -> Unit) {
        Thread {
            val songsTable = songDao.getSongs()
            if (songsTable != null)
                onSuccess(songsTable.results)
            else
                onError(SOMETHING_WENT_WRONG)

        }.start()
    }
}