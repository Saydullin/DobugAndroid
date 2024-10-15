package com.saydullin.codehub.presentation.component.editor.input.ui

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.saydullin.codehub.presentation.component.editor.input.ui.util.InputTypeEditor

@OptIn(ExperimentalLayoutApi::class, ExperimentalCoilApi::class)
@Composable
fun InputMediaEditor(
    modifier: Modifier = Modifier,
    isBigContent: Boolean = false,
    textStyle: TextStyle = MaterialTheme.typography.displaySmall,
    onInputEdit: (String) -> Unit,
    placeholder: String,
    label: String? = null,
    contentLimit: Int = 0,
    inputType: InputTypeEditor = InputTypeEditor.TEXT
) {

    val input = remember { mutableStateOf("") }
    val selectedImages = remember { mutableStateOf<List<Uri>>(listOf()) }
    val attachmentIcons = listOf(
        Icons.Default.Add to "Add" to 1,
        Icons.Default.Settings to "File" to 2,
        Icons.Default.Clear to "Clear" to 3,
        Icons.Default.Add to "Add" to 4,
        Icons.Default.Settings to "File" to 5,
        Icons.Default.Clear to "Clear" to 6,
        Icons.Default.Add to "Add" to 7,
        Icons.Default.Settings to "File" to 8,
        Icons.Default.Clear to "Clear" to 9,
    )
    val pickMultipleMedia =
        rememberLauncherForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(10)) { uris ->
            if (uris.isNotEmpty()) {
                Log.d("PhotoPicker", "Number of items selected: ${uris.size}")
                selectedImages.value = uris
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
        ) {
            if (label != null) {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    style = MaterialTheme.typography.titleMedium,
                    text = label
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            if (contentLimit != 0) {
                AnimatedVisibility(
                    visible = input.value.length > (contentLimit - 31),
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Text(
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        text = "${input.value.length}/$contentLimit"
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(16.dp)
                ),
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(attachmentIcons) {
                    IconButton(
                        onClick = {
                            pickMultipleMedia.launch(
                                PickVisualMediaRequest(
                                    ActivityResultContracts.PickVisualMedia.ImageAndVideo
                                )
                            )
                        }
                    ) {
                        Icon(
                            imageVector = it.first.first,
                            contentDescription = it.first.second,
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
            if (selectedImages.value.isNotEmpty()) {
                FlowRow(
                    modifier = Modifier
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    selectedImages.value.forEach {
                        Image(
                            modifier = Modifier
                                .width(90.dp)
                                .height(90.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .clickable {  },
                            painter = rememberImagePainter(it),
                            contentDescription = "images",
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = if (isBigContent) 100.dp else 0.dp),
                value = input.value,
                onValueChange = {
                    if (contentLimit == 0 || it.length <= contentLimit) {
                        onInputEdit(it)
                        input.value = it
                    }
                },
                placeholder = {
                    Text(
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.outline,
                        text = placeholder,
                    )
                },
                shape = RoundedCornerShape(16.dp),
                textStyle = textStyle,
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
    }

}