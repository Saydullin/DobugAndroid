package com.saydullin.data.repository.tag

import com.saydullin.data.database.dao.TagDao
import com.saydullin.data.di.mapper.tag.TagEntityToTagMapper
import com.saydullin.data.di.mapper.tag.TagToTagEntityMapper
import com.saydullin.domain.model.tag.Tag
import com.saydullin.domain.repository.tag.TagLocalRepository
import com.saydullin.domain.util.response.Resource
import com.saydullin.domain.util.response.StatusType
import javax.inject.Inject

class TagLocalRepositoryImpl @Inject constructor(
    private val tagDao: TagDao,
    private val tagEntityMapper: TagEntityToTagMapper,
    private val tagMapper: TagToTagEntityMapper,
): TagLocalRepository {

    override suspend fun getAllTags(): Resource<List<Tag>> {
        return Resource.tryWith(StatusType.DATABASE_ERROR) {
            val tagEntityList = tagDao.getAllTags()

            tagEntityList.map { tagEntityMapper.map(it) }
        }
    }

    override suspend fun getTagsByTitle(title: String): Resource<List<Tag>> {
        return Resource.tryWith(StatusType.DATABASE_ERROR) {
            val tagEntityList = tagDao.getTagByTitle(title)

            tagEntityList.map { tagEntityMapper.map(it) }
        }
    }

    override suspend fun saveTags(tags: List<Tag>): Resource<Unit> {
        return Resource.tryWith(StatusType.DATABASE_ERROR) {
            val tagEntityList = tags.map { tagMapper.map(it) }

            tagDao.saveTags(tagEntityList)
        }
    }

}