package com.saydullin.domain.usecase.post

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.response.Paging
import com.saydullin.domain.repository.PostRepository
import com.saydullin.domain.util.response.Resource
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

    suspend fun execute(): Resource<MainResponse<Paging<Post>>> {
        return postRepository.getAll()
    }

}