package com.saydullin.data.di.mapper.author

import com.saydullin.data.database.entities.AuthorEntity
import com.saydullin.domain.di.mapper.Mapper
import com.saydullin.domain.model.post.Author
import javax.inject.Inject

class AuthorToAuthorEntityMapper @Inject constructor(
): Mapper<Author, AuthorEntity> {

    override fun map(from: Author): AuthorEntity {
        return AuthorEntity(
            id = from.id,
            firstName = from.firstName,
            middleName = from.middleName,
            lastName = from.lastName,
            username = from.username,
        )
    }

}