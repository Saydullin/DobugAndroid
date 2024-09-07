package com.saydullin.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.data.database.entities.AuthorEntity

@Dao
interface AuthorDao {

    @Query("SELECT * FROM AuthorEntity")
    fun getAuthor(): AuthorEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAuthor(author: AuthorEntity): Long

}