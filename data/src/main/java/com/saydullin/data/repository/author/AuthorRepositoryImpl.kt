package com.saydullin.data.repository.author

import com.saydullin.data.database.dao.AuthorDao
import com.saydullin.data.di.mapper.author.AuthorEntityToAuthorMapper
import com.saydullin.data.di.mapper.author.AuthorToAuthorEntityMapper
import com.saydullin.data.server.service.AuthorService
import com.saydullin.domain.model.post.Author
import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.repository.author.AuthorRepository
import com.saydullin.domain.util.response.Resource
import com.saydullin.domain.util.response.StatusType
import javax.inject.Inject

class AuthorRepositoryImpl @Inject constructor(
    private val authorService: AuthorService,
    private val authorDao: AuthorDao,
    private val authorToAuthorEntityMapper: AuthorToAuthorEntityMapper,
    private val authorEntityToAuthorMapper: AuthorEntityToAuthorMapper,
): AuthorRepository {

    override suspend fun getServerAuthor(): Resource<MainResponse<Author>> {
        return try {
            val authorCall = authorService.getAuthor()
            val author = authorCall.execute()

            if (author.isSuccessful && author.body() != null) {
                return Resource.Success(author.body())
            }

            Resource.Success(null)
        } catch (e: Exception) {
            Resource.Error(
                e = e,
                status = StatusType.SERVER_ERROR
            )
        }
    }

    override suspend fun getLocalAuthor(): Resource<Author> {
        return try {
            val authorEntity = authorDao.getAuthor()
                ?: return Resource.Error(
                    status = StatusType.DATA_NOT_FOUND
                )

            val author = authorEntityToAuthorMapper.map(authorEntity)

            Resource.Success(author)
        } catch (e: Exception) {
            Resource.Error(
                e = e,
                status = StatusType.DATABASE_ERROR
            )
        }
    }

    override suspend fun saveServerAuthor(author: Author): Resource<MainResponse<Unit>> {
        return try {
            val authorCall = authorService.saveAuthor(author)
            val authorResponse = authorCall.execute()

            if (authorResponse.isSuccessful && authorResponse.body() != null) {
                return Resource.Success(authorResponse.body())
            }

            Resource.Error(
                status = StatusType.DATABASE_ERROR
            )
        } catch (e: Exception) {
            Resource.Error(
                e = e,
                status = StatusType.DATABASE_ERROR
            )
        }
    }

    override suspend fun saveLocalAuthor(author: Author): Resource<Unit> {
        return try {
            val authorEntity = authorToAuthorEntityMapper.map(author)
            val savedId = authorDao.saveAuthor(authorEntity)

            if (savedId == -1L) {
                return Resource.Error(
                    status = StatusType.DATABASE_ERROR
                )
            }

            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(
                e = e,
                status = StatusType.DATABASE_ERROR
            )
        }
    }

}