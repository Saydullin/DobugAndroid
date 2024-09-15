package com.saydullin.data.di.mapper.post

import com.saydullin.data.database.entities.PostEntity
import com.saydullin.domain.di.mapper.Mapper
import com.saydullin.domain.model.post.Post
import javax.inject.Inject

class PostEntityToPostMapper @Inject constructor(
): Mapper<PostEntity, Post> {

    override fun map(from: PostEntity): Post {
        return Post(
            id = from.id,
            previewImage = from.previewImage,
            title = from.title,
            description = from.description,
            author = null,
            tags = null,
            views = from.views,
            createdAt = from.createdAt,
            updatedAt = from.updatedAt,
            likes = null,
            comments = null,
            attachments = null,
            type = from.type,
            status = from.status
        )
    }

}