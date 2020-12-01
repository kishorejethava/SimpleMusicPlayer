package com.kishorejethava.simplemusicplayer.storage.database.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kishorejethava.simplemusicplayer.model.ResFeed
import java.lang.reflect.Type

object SongTypeConverter {

    @TypeConverter
    @JvmStatic
    fun toJson(value: ResFeed) = Gson().toJson(value)

    @TypeConverter
    @JvmStatic
    fun fromJson(value: String): ResFeed {
        val listType: Type = object : TypeToken<ResFeed>() {}.type
        return Gson().fromJson(value, listType)
    }

}