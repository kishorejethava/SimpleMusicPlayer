package com.kishorejethava.simplemusicplayer.model

interface SongsRepository {
    suspend fun fetchSongs(onSuccess: (ResFeed) -> Unit, onError: (String) -> Unit)
    fun getSongsLocal(onSuccess: (ResFeed?) -> Unit, onError: (String) -> Unit)
}