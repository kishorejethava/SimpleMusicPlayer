package com.kishorejethava.simplemusicplayer.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.kishorejethava.simplemusicplayer.model.ResFeed
import com.kishorejethava.simplemusicplayer.model.SongsRepositoryImpl
import com.kishorejethava.simplemusicplayer.utils.isNetworkAvailable
import kotlinx.coroutines.launch

class SongListViewModel(
    application: Application,
    private val songsRepository: SongsRepositoryImpl
) : AndroidViewModel(application) {

    private val _feedResponse = MutableLiveData<ResFeed>()
    val feedResponse: LiveData<ResFeed>
        get() = _feedResponse

    private val _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String>
        get() = _errorResponse

    init {
        viewModelScope.launch {
            if (isNetworkAvailable(application)) {
                songsRepository.fetchSongs({ songResponse ->
                    _feedResponse.postValue(songResponse)
                }, { error ->
                    _errorResponse.postValue(error)
                })
            } else {
                songsRepository.getSongsLocal({ songResponse ->
                    _feedResponse.postValue(songResponse)
                }, { error ->
                    _errorResponse.postValue(error)
                })
            }
        }
    }
}