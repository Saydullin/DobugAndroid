package com.saydullin.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saydullin.domain.model.post.Author

@Entity
data class PostEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val previewImage: String,
    val title: String,
    val description: String,
    val author: Int,
    val content: String,
    val tags: Int,
    val views: Int,
    val createdAt: Long,
    val updatedAt: Long,
    val likes: Int,
    val comments: Int,
    val attachments: Int,
    val type: String,
    val status: String
)


