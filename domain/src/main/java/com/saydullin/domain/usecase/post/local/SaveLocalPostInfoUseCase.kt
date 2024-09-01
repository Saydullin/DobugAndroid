package com.saydullin.domain.usecase.post.local

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.repository.post.PostLocalRepository
import com.saydullin.domain.util.response.Resource
import javax.inject.Inject

class SaveLocalPostInfoUseCase @Inject constructor(
    private val postLocalRepository: PostLocalRepository
) {

    suspend fun execute(post: Post): Resource<Unit> {
        return postLocalRepository.savePost(post)
    }

}