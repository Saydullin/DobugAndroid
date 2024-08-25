package com.saydullin.domain.usecase.post

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.repository.PostRepository
import com.saydullin.domain.util.response.Resource
import javax.inject.Inject

class SavePostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

    suspend fun execute(post: Post): Resource<Unit> {
        return postRepository.savePost(post)
    }

}