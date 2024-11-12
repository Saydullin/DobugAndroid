package com.saydullin.data.di.mapper.tag

import com.saydullin.data.database.entities.TagEntity
import com.saydullin.domain.di.mapper.Mapper
import com.saydullin.domain.model.tag.Tag
import javax.inject.Inject

class TagEntityToTagMapper @Inject constructor(
): Mapper<TagEntity, Tag> {

    override fun map(from: TagEntity): Tag {
        return Tag(
            id = from.id,
            title = from.title,
            type = from.type,
        )
    }

}