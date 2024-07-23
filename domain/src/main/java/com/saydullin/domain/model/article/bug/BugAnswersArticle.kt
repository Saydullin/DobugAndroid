package com.saydullin.domain.model.article.bug

data class BugAnswersArticle(
    val id: Int,
    val description: String,
    val repliedTo: Int,
)