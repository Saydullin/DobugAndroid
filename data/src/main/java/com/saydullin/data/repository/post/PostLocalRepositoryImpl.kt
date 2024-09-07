package com.saydullin.data.repository.post

import com.saydullin.data.database.dao.PostDao
import com.saydullin.data.di.mapper.post.PostEntityToPostMapper
import com.saydullin.data.di.mapper.post.PostToPostEntityMapper
import com.saydullin.domain.model.post.Post
import com.saydullin.domain.repository.post.PostLocalRepository
import com.saydullin.domain.util.response.Resource
import com.saydullin.domain.util.response.StatusType
import javax.inject.Inject

class PostLocalRepositoryImpl @Inject constructor(
    private val postDao: PostDao,
    private val postEntityToPostMapper: PostEntityToPostMapper,
    private val postToPostEntityMapper: PostToPostEntityMapper,
): PostLocalRepository {

    override suspend fun getAll(): Resource<List<Post>> {
        return try {
            val postEntityList = postDao.getAllPost()
            val postEntity = postEntityList.map { postEntityToPostMapper.map(it) }

            Resource.Success(postEntity)
        } catch (e: Exception) {
            Resource.Error(
                e = e,
            )
        }
    }

    override suspend fun getById(id: Long): Resource<Post> {
        return try {
            val postEntity = postDao.getPost(id)
                ?: return Resource.Error(
                    status = StatusType.DATA_NOT_FOUND
                )

            val post = postEntityToPostMapper.map(postEntity)

            Resource.Success(post)
        } catch (e: Exception) {
            Resource.Error(
                e = e,
            )
        }
    }

    override suspend fun savePost(post: Post): Resource<Unit> {
        return try {
            val postEntity = postToPostEntityMapper.map(post)

            postDao.insert(postEntity)

            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(
                e = e,
            )
        }
    }

}


