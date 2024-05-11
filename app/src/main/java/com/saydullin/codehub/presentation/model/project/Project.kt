package com.saydullin.codehub.presentation.model.project

import com.saydullin.codehub.domain.model.article.ArticleAuthor
import com.saydullin.codehub.domain.model.article.ArticleTag

data class Project(
    val id: Int,
    val title: String,
    val description: String,
    val images: List<String>,
    val views: Int,
    val author: ArticleAuthor,
    val tags: List<ArticleTag>
)


