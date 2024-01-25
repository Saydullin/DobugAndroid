package com.saydullin.codehub.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.codehub.data.db.entities.ArticleEntity

@Dao
interface ArticleDao {

    @Query("SELECT * FROM ArticleEntity")
    fun getAllArticles(): List<ArticleEntity>

    @Insert(ArticleEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: ArticleEntity)

}