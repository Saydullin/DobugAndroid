package com.saydullin.domain.model.post

data class Post(
    val id: Int,
    val previewImage: String?,
    val title: String,
    val description: String,
    val author: Author,
    val content: String,
    val tags: List<String>?,
    val views: Int,
    val createdAt: Long,
    val updatedAt: Long,
    val likes: List<String>,
    val comments: List<String>,
    val attachments: List<String>,
    val type: String,
    val status: String
)