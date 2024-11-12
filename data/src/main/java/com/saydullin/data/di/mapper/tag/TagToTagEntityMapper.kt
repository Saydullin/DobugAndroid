package com.saydullin.data.di.mapper.tag

import com.saydullin.data.database.entities.TagEntity
import com.saydullin.domain.di.mapper.Mapper
import com.saydullin.domain.model.tag.Tag
import javax.inject.Inject

class TagToTagEntityMapper @Inject constructor(
): Mapper<Tag, TagEntity> {

    override fun map(from: Tag): TagEntity {
        return TagEntity(
            id = from.id,
            title = from.title,
            type = from.type,
        )
    }

}