package com.saydullin.data.repository

import com.saydullin.data.server.service.PostService
import com.saydullin.domain.model.post.Post
import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.response.Paging
import com.saydullin.domain.repository.PostRepository
import com.saydullin.domain.util.response.Resource
import com.saydullin.domain.util.response.StatusType
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postService: PostService
): PostRepository {

    override suspend fun getAll(): Resource<MainResponse<Paging<Post>>> {
        return try {
            val allPosts = postService.getAll()
            val postsResponse = allPosts.execute()
            if (postsResponse.isSuccessful && postsResponse.body() != null) {
                return Resource.Success(postsResponse.body())
            } else {
                throw Exception("getAll() posts from server not successful: ${postsResponse.raw()}")
            }
        } catch (e: Exception) {
            Resource.Error(
                e = e,
                status = StatusType.SERVER_ERROR
            )
        }
    }

    override suspend fun getById(id: Int): Resource<MainResponse<Post?>> {
        return try {
            val allPosts = postService.getById(id)
            val postsResponse = allPosts.execute()
            if (postsResponse.isSuccessful && postsResponse.body() != null) {
                return Resource.Success(postsResponse.body())
            } else {
                throw Exception("getById($id) posts from server not successful: ${postsResponse.raw()}")
            }
        } catch (e: Exception) {
            Resource.Error(
                e = e,
                status = StatusType.SERVER_ERROR
            )
        }
    }

    override suspend fun savePost(post: Post): Resource<Unit> {
        return try {
            val savePost = postService.savePost(post)
            val postResponse = savePost.execute()
            if (postResponse.isSuccessful) {
                return Resource.Success(Unit)
            } else {
                throw Exception("savePost($post) to server not successful: ${postResponse.raw()}")
            }
        } catch (e: Exception) {
            Resource.Error(
                e = e,
                status = StatusType.SERVER_ERROR
            )
        }
    }

}