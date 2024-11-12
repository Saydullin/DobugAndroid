package com.saydullin.domain.usecase.tag.local

import com.saydullin.domain.model.tag.Tag
import com.saydullin.domain.repository.tag.TagLocalRepository
import com.saydullin.domain.util.response.Resource
import javax.inject.Inject

class GetLocalTagsByTitleUseCase @Inject constructor(
    private val tagLocalRepository: TagLocalRepository
) {

    suspend fun execute(title: String): Resource<List<Tag>> {
        return tagLocalRepository.getTagsByTitle(title)
    }

}