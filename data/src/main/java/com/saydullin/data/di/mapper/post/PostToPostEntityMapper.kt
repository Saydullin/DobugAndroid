package com.saydullin.data.di.mapper.post

import com.saydullin.data.database.entities.PostEntity
import com.saydullin.domain.di.mapper.Mapper
import com.saydullin.domain.model.post.Post
import javax.inject.Inject

class PostToPostEntityMapper @Inject constructor(
): Mapper<Post, PostEntity> {

    override fun map(from: Post): PostEntity {
        return PostEntity(
            id = from.id,
            previewImage = from.previewImage ?: "",
            title = from.title,
            description = from.description,
            authorId = -1,
            content = from.content,
            tags = -1,
            views = from.views,
            createdAt = from.createdAt,
            updatedAt = from.updatedAt,
            likes = -1,
            comments = -1,
            attachments = -1,
            type = from.type,
            status = from.status
        )
    }

}