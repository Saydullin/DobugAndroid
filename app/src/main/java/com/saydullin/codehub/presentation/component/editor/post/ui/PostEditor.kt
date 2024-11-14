package com.saydullin.codehub.presentation.component.editor.post.ui

import android.net.Uri
import android.widget.Space
import android.widget.Toast
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
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.R
import com.saydullin.codehub.presentation.component.editor.post.model.PostEditorSettings
import com.saydullin.codehub.presentation.component.editor.post.model.PostEditorTextSetting

@Composable
fun PostEditor(
    modifier: Modifier = Modifier,
    titleDefault: String = "",
    onTitleEdit: ((String) -> Unit),
    contentDefault: String = "",
    onContentEdit: (String) -> Unit,
    onAttachmentEdit: (List<Uri>) -> Unit,
    titleSetting: PostEditorTextSetting = PostEditorTextSetting.default,
    descriptionSetting: PostEditorTextSetting = PostEditorTextSetting.default,
    onSubmit: () -> Unit,
    header: (@Composable () -> Unit)? = null,
    footer: (@Composable () -> Unit)? = null,
    content: (LazyListScope.() -> Unit)? = null,
) {

    val titleInput = remember { mutableStateOf(titleDefault) }
    val descriptionInput = remember { mutableStateOf(contentDefault) }

    LazyColumn(
        modifier = modifier,
    ) {

        if (header != null) {
            item {
                header.invoke()
            }
        }

        content?.invoke(this@LazyColumn)

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

        item {
            Spacer(modifier = Modifier.height(70.dp))
            Button(
                modifier = Modifier.padding(horizontal = 16.dp),
                onClick = onSubmit
            ) {
                Text(
                    text = stringResource(R.string.publish)
                )
            }
        }

        if (footer != null) {
            item {
                footer.invoke()
            }
        }

    }

}