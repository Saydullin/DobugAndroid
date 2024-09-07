package com.saydullin.data.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.saydullin.data.database.entities.AuthorEntity
import com.saydullin.data.database.entities.PostEntity

data class PostWithAuthorEntity(
    @Embedded val post: PostEntity,
    @Relation(
        parentColumn = "authorId",
        entityColumn = "id"
    )
    val author: AuthorEntity,
)