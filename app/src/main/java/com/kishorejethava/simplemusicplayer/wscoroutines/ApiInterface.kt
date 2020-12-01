package com.kishorejethava.simplemusicplayer.wscoroutines

import com.kishorejethava.simplemusicplayer.model.ResFeed
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=20/json")
    fun getSongsAsync() : Deferred<Response<ResFeed>>
}