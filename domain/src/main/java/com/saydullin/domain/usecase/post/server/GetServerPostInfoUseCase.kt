package com.saydullin.domain.usecase.post.server

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.repository.post.PostServerRepository
import com.saydullin.domain.util.response.Resource
import javax.inject.Inject

class GetServerPostInfoUseCase @Inject constructor(
    private val postServerRepository: PostServerRepository
) {

    suspend fun execute(id: Long): Resource<MainResponse<Post?>> {
        return postServerRepository.getById(id)
    }

}