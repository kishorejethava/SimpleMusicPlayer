package com.kishorejethava.simplemusicplayer.injections

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.kishorejethava.simplemusicplayer.utils.Constants
import com.kishorejethava.simplemusicplayer.wscoroutines.ApiInterface
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appNetworkModule = module {
    // Dependency: Retrofit
    single {
        Retrofit.Builder()
                .baseUrl(Constants.BASE_API_URL)
                .client(get())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    // Dependency: ApiService
    single {
        val retrofit: Retrofit = get()
        retrofit.create(ApiInterface::class.java)
    }

    // Dependency: OkHttpClient
    single {
        OkHttpClient.Builder()
                .connectTimeout(60 * 2, TimeUnit.SECONDS)
                .readTimeout(60 * 2, TimeUnit.SECONDS)
                .writeTimeout(60 * 2, TimeUnit.SECONDS)
                .build()
    }

}