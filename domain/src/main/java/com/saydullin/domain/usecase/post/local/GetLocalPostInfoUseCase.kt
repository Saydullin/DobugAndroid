package com.saydullin.domain.usecase.post.local

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.repository.post.PostLocalRepository
import com.saydullin.domain.util.response.Resource
import javax.inject.Inject

class GetLocalPostInfoUseCase @Inject constructor(
    private val postLocalRepository: PostLocalRepository
) {

    suspend fun execute(id: Long): Resource<Post> {
        return postLocalRepository.getById(id)
    }

}