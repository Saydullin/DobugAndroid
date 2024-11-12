package com.saydullin.domain.usecase.tag.remote

import com.saydullin.domain.model.tag.Tag
import com.saydullin.domain.repository.tag.TagLocalRepository
import com.saydullin.domain.repository.tag.TagServerRepository
import com.saydullin.domain.util.response.Resource
import javax.inject.Inject

class GetAllServerTagsUseCase @Inject constructor(
    private val tagServerRepository: TagServerRepository
) {

    suspend fun execute(): Resource<List<Tag>> {
        return tagServerRepository.getAllTags()
    }

}