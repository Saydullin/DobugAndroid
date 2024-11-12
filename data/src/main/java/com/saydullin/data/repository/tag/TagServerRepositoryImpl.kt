package com.saydullin.data.repository.tag

import com.saydullin.data.server.service.TagService
import com.saydullin.domain.model.tag.Tag
import com.saydullin.domain.repository.tag.TagServerRepository
import com.saydullin.domain.util.response.Resource
import com.saydullin.domain.util.response.StatusType
import javax.inject.Inject

class TagServerRepositoryImpl @Inject constructor(
    private val tagService: TagService
): TagServerRepository {

    override suspend fun getAllTags(): Resource<List<Tag>> {
        return Resource.tryWith(StatusType.SERVER_ERROR) {
            val tagResponse = tagService.getAllTags()

            if (tagResponse.isSuccessful && tagResponse.body()?.isSuccess == true) {
                return@tryWith tagResponse.body()?.data ?: throw Exception("No data")
            }

            throw Exception("Server response not successful")
        }
    }

}