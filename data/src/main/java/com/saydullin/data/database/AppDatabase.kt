package com.saydullin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saydullin.data.database.converter.IntListConverter
import com.saydullin.data.database.dao.ArticleDao
import com.saydullin.data.database.dao.PostDao
import com.saydullin.data.database.entities.ArticleEntity
import com.saydullin.data.database.entities.AuthorEntity
import com.saydullin.data.database.entities.PostEntity

@Database(
    entities = [
        ArticleEntity::class,
        PostEntity::class,
        AuthorEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(
    IntListConverter::class
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    abstract fun postDao(): PostDao

}


