package com.saydullin.codehub.domain.model.article.news

import com.saydullin.codehub.domain.model.article.ArticleAuthor

data class NewsArticle(
    val id: Int,
    val imageUrl: String,
    val author: ArticleAuthor,
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


