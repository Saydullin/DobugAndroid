package com.saydullin.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saydullin.data.database.entities.ArticleEntity

@Dao
interface ArticleDao {

    @Query("SELECT * FROM ArticleEntity")
    fun getAllArticles(): List<ArticleEntity>

    @Insert(ArticleEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: ArticleEntity)

}