package com.saydullin.codehub.di.mapper

import com.saydullin.codehub.presentation.model.post.PostUI
import com.saydullin.domain.di.mapper.Mapper
import com.saydullin.domain.model.post.Author
import com.saydullin.domain.model.post.Post
import java.util.Date
import javax.inject.Inject

class PostUItoPostMapper @Inject constructor(
): Mapper<PostUI, Post> {

    override fun map(from: PostUI): Post {
        return Post(
            id = -1,
            previewImage = null,
            title = from.title,
            description = from.description,
            author = Author(
                id = -1,
                firstName = "Saydullin",
                middleName = "",
                lastName = ""
            ),
            content = "",
            tags = listOf(),
            views = 0,
            createdAt = Date().time,
            updatedAt = Date().time,
            likes = listOf(),
            comments = listOf(),
            attachments = listOf(),
            type = "",
            status = ""
        )
    }

}