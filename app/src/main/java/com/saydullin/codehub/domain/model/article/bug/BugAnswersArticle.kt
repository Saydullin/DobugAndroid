package com.saydullin.codehub.domain.model.article.bug

data class BugAnswersArticle(
    val id: Int,
    val description: String,
    val repliedTo: Int,
)