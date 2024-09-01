package com.saydullin.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.data.database.entities.ArticleEntity
import com.saydullin.data.database.entities.PostEntity

@Dao
interface PostDao {

    @Query("SELECT * FROM PostEntity")
    fun getAllPost(): List<PostEntity>

    @Query("SELECT * FROM PostEntity WHERE id = :id")
    fun getPost(id: Long): PostEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: PostEntity)

}