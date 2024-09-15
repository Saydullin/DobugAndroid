package com.saydullin.data.di.mapper.author

import com.saydullin.data.database.entities.AuthorEntity
import com.saydullin.domain.di.mapper.Mapper
import com.saydullin.domain.model.post.Author
import javax.inject.Inject

class AuthorEntityToAuthorMapper @Inject constructor(
): Mapper<AuthorEntity, Author> {

    override fun map(from: AuthorEntity): Author {
        return Author(
            id = from.id,
            firstName = from.firstName,
            middleName = from.middleName,
            lastName = from.lastName,
        )
    }

}