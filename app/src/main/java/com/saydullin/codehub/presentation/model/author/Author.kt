package com.saydullin.codehub.presentation.model.author

import com.saydullin.codehub.domain.model.article.ArticleTag

data class Author(
    val id: Int,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val userName: String,
    val nickName: String,
    val profileImageUrl: String,
    val useful: Int,
    val answers: Int,
    val tags: List<ArticleTag>,
    val bio: String,
    val regDate: Long,
    val updatedDate: Long,
)


