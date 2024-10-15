package com.saydullin.codehub.presentation.component.editor.post.model

import com.saydullin.domain.model.post.PostAttachment

data class PostEditorAttachmentSettings(
    val count: Int = 10,
    val type: PostAttachment = PostAttachment.IMAGE_AND_VIDEO,
)