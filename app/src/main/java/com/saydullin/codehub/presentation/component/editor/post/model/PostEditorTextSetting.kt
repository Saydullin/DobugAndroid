package com.saydullin.codehub.presentation.component.editor.post.model

import androidx.compose.ui.text.TextStyle

data class PostEditorTextSetting(
    val placeholder: String,
    val count: Int,
    val style: TextStyle?
) {

    companion object {
        val default = PostEditorTextSetting(
            placeholder = "",
            count = 100,
            style = null
        )
    }

}