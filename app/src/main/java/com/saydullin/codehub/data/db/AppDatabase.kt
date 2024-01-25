package com.saydullin.codehub.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saydullin.codehub.data.db.converter.IntListConverter
import com.saydullin.codehub.data.db.dao.ArticleDao
import com.saydullin.codehub.data.db.entities.ArticleEntity

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