package com.saydullin.codehub.domain.model.article.bug

import com.saydullin.codehub.domain.model.article.ArticleAuthor
import com.saydullin.codehub.domain.model.article.ArticleTag

data class BugArticle(
    val id: Int,
    val previewImage: String,
    val title: String,
    val description: String,
    val author: ArticleAuthor,
    val isFixed: Boolean,
    val isDeprecated: Boolean,
    val views: Int,
    val answers: List<BugAnswersArticle>,
    val tags: List<ArticleTag>,
    val useful: Int,
    val publishedDate: Long,
    val updatedDate: Long,
)


