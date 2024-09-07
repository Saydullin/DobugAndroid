package com.saydullin.domain.usecase.post.server

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.repository.post.PostServerRepository
import com.saydullin.domain.util.response.Resource
import javax.inject.Inject

class SaveServerPostUseCase @Inject constructor(
    private val postServerRepository: PostServerRepository,
) {

    suspend fun execute(post: Post): Resource<Unit> {
        return postServerRepository.savePost(post)
    }

}


