package com.saydullin.codehub.presentation.model.post

import com.saydullin.codehub.presentation.model.common.Attachment

data class PostUI(
    val previewImages: List<String>,
    val title: String,
    val description: String,
    val attachments: List<Attachment>,
    val tags: List<Long>,
    val type: String,
    val status: String,
)


