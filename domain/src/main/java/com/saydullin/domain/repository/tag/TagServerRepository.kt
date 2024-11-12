package com.saydullin.domain.repository.tag

import com.saydullin.domain.model.tag.Tag
import com.saydullin.domain.util.response.Resource

interface TagServerRepository {

    suspend fun getAllTags(): Resource<List<Tag>>

}