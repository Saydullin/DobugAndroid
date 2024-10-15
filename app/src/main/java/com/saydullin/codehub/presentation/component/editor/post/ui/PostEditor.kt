package com.saydullin.codehub.presentation.component.editor.post.ui

import android.net.Uri
import android.widget.Space
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.component.editor.post.model.PostEditorSettings
import com.saydullin.codehub.presentation.component.editor.post.model.PostEditorTextSetting

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostEditor(
    modifier: Modifier = Modifier,
    header: (@Composable () -> Unit)? = null,
    footer: (@Composable () -> Unit)? = null,
    settings: PostEditorSettings = PostEditorSettings.default,
    onTitleEdit: ((String) -> Unit),
    onContentEdit: (String) -> Unit,
    onAttachmentEdit: (List<Uri>) -> Unit,
    titleSetting: PostEditorTextSetting = PostEditorTextSetting.default,
    descriptionSetting: PostEditorTextSetting = PostEditorTextSetting.default,
    onSubmit: () -> Unit
) {

    val titleInput = remember { mutableStateOf("") }
    val descriptionInput = remember { mutableStateOf("") }
    val attachmentsUri = remember { mutableStateOf<List<Uri>>(listOf()) }
    val pickMultipleMedia = rememberLauncherForActivityResult(
        ActivityResultContracts.PickMultipleVisualMedia(settings.attachment.count)
    ) { uris ->
        if (uris.isNotEmpty()) {
            attachmentsUri.value = uris
        }
    }

    LazyColumn(
        modifier = modifier,
    ) {
        if (header != null) {
            item {
                header.invoke()
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = titleInput.value,
                onValueChange = {
                    if (titleSetting.count == 0 || it.length <= titleSetting.count) {
                        onTitleEdit(it)

                        titleInput.value = it
                    }
                },
                placeholder = {
                    Text(
                        style = titleSetting.style ?: MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.outline,
                        text = titleSetting.placeholder,
                    )
                },
                shape = RoundedCornerShape(16.dp),
                textStyle = titleSetting.style ?: MaterialTheme.typography.displayLarge,
                label = null,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                ),
            )
        }
        stickyHeader {
            PostAttachmentBarEditor()
        }
        item {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = descriptionInput.value,
                onValueChange = {
                    if (descriptionSetting.count == 0 || it.length <= descriptionSetting.count) {
                        onContentEdit(it)

                        descriptionInput.value = it
                    }
                },
                placeholder = {
                    Text(
                        style = descriptionSetting.style ?: MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.outline,
                        text = descriptionSetting.placeholder,
                    )
                },
                textStyle = descriptionSetting.style ?: MaterialTheme.typography.displayLarge,
                label = null,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                ),
            )
        }
        if (footer != null) {
            item {
                footer.invoke()
            }
        }
    }

}