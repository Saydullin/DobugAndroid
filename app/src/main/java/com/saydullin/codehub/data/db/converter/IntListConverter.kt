package com.saydullin.codehub.data.db.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class IntListConverter {

    @TypeConverter
    fun fromIntListToString(item: List<Int>): String? {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun fromStringToItem(json: String): List<Int>? {
        val listType = object: TypeToken<List<Int>>(){}.type
        return Gson().fromJson(json, listType)
    }

}