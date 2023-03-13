package com.xavijimenezmulet.local.converter

import androidx.room.TypeConverter
import com.xavijimenezmulet.utils.extension.fromJson
import com.xavijimenezmulet.utils.extension.toJson

class StringListConverter {
    @TypeConverter
    fun toListOfStrings(stringValue: String): List<String>? {
        return stringValue.fromJson()
    }

    @TypeConverter
    fun fromListOfStrings(listOfString: List<String>?): String {
        return listOfString.toJson()
    }
}