package com.saydullin.domain.repository.author

import com.saydullin.domain.model.post.Author
import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.util.response.Resource

interface AuthorRepository {

    suspend fun getServerAuthor(): Resource<MainResponse<Author>>

    suspend fun getLocalAuthor(): Resource<Author>

    suspend fun saveServerAuthor(author: Author): Resource<MainResponse<Unit>>

    suspend fun saveLocalAuthor(author: Author): Resource<Unit>

}