package com.saydullin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saydullin.data.database.converter.IntListConverter
import com.saydullin.data.database.dao.ArticleDao
import com.saydullin.data.database.entities.ArticleEntity

@Database(
    entities = [
        ArticleEntity::class
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(
    IntListConverter::class
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun articleDao(): ArticleDao

}


