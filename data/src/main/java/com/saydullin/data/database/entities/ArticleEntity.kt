package com.saydullin.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleEntity(
    @PrimaryKey val id: Int,
    val image: String,
    val author: Int,
    val title: String,
    val description: String,
    val content: String,
    val views: Int,
    val likes: Int,
    val publishDate: Long,
    val updatedDate: Long,
    val tags: List<Int>,
    val comments: List<Int>,
    val link: String,
    val relatedArticles: List<Int>,
    val isPublished: Boolean,
    val averageRating: Float,
)
