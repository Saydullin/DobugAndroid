package com.saydullin.domain.repository

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.response.Paging
import com.saydullin.domain.util.response.Resource

interface PostRepository {

    suspend fun getAll(): Resource<MainResponse<Paging<Post>>>

    suspend fun getById(id: Int): Resource<MainResponse<Post?>>

    suspend fun savePost(post: Post): Resource<Unit>

}