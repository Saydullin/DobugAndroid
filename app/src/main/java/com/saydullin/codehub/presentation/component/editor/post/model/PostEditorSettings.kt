package com.saydullin.codehub.presentation.component.editor.post.model

import com.saydullin.domain.model.post.PostAttachment

data class PostEditorSettings(
    val attachment: PostEditorAttachmentSettings,
    val textStyle: PostEditorTextStyleSettings?,
    val count: PostEditorLimitSettings,
) {

    companion object {
        val default = PostEditorSettings(
            attachment = PostEditorAttachmentSettings(
                count = 10,
                type = PostAttachment.IMAGE_AND_VIDEO
            ),
            count = PostEditorLimitSettings(
                title = 100,
                description = 1000,
            ),
            textStyle = null,
        )
    }

}