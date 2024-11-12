package com.saydullin.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.data.database.entities.TagEntity

@Dao
interface TagDao {

    @Query("SELECT * FROM TagEntity")
    fun getAllTags(): List<TagEntity>

    @Query("SELECT * FROM TagEntity WHERE title LIKE :title")
    fun getTagByTitle(title: String): List<TagEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTags(tags: List<TagEntity>)

    @Query("DELETE FROM TagEntity")
    fun clear()

}