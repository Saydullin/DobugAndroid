package com.saydullin.domain.repository.tag

import com.saydullin.domain.model.tag.Tag
import com.saydullin.domain.util.response.Resource

interface TagLocalRepository {

    suspend fun getAllTags(): Resource<List<Tag>>

    suspend fun getTagsByTitle(title: String): Resource<List<Tag>>

    suspend fun saveTags(tags: List<Tag>): Resource<Unit>

}