package com.kishorejethava.simplemusicplayer.injections

import com.kishorejethava.simplemusicplayer.model.SongsRepositoryImpl
import com.kishorejethava.simplemusicplayer.viewmodel.SongDetailViewModel
import com.kishorejethava.simplemusicplayer.viewmodel.SongListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    single {
        SongsRepositoryImpl(get(),get())
    }

    viewModel {
       SongListViewModel(get(), get())
    }
    viewModel {
        SongDetailViewModel(get())
    }

}