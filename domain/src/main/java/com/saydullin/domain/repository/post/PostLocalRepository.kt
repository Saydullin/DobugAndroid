package com.saydullin.domain.repository.post

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.response.Paging
import com.saydullin.domain.util.response.Resource

interface PostLocalRepository {

    suspend fun getAll(): Resource<List<Post>>

    suspend fun getById(id: Long): Resource<Post>

    suspend fun savePost(post: Post): Resource<Unit>

}