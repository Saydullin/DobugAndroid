package com.saydullin.domain.model.post

import com.saydullin.domain.model.tag.Tag

data class Post(
    val id: Int,
    val previewImage: String?,
    val title: String,
    val description: String,
    val author: Author?,
    val tags: List<Tag>?,
    val views: Int,
    val createdAt: Long,
    val updatedAt: Long,
    val likes: List<String>?,
    val comments: List<String>?,
    val attachments: List<String>?,
    val type: String,
    val status: String
)