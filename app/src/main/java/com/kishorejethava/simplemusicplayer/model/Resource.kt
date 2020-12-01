package com.kishorejethava.simplemusicplayer.model

import com.google.gson.annotations.Expose


sealed class Resource<out T> {
    class Success<out T>(@Expose val data: T) : Resource<T>()
    class Error<out T>(@Expose val error: String) : Resource<T>()
}