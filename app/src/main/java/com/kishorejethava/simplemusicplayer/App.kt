package com.kishorejethava.simplemusicplayer

import android.app.Application
import com.kishorejethava.simplemusicplayer.injections.appNetworkModule
import com.kishorejethava.simplemusicplayer.injections.databaseModule
import com.kishorejethava.simplemusicplayer.injections.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule, appNetworkModule, databaseModule))
        }

    }
}