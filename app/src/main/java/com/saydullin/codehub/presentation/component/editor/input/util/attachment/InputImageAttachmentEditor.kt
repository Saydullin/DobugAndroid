package com.saydullin.codehub.presentation.component.editor.input.util.attachment

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@OptIn(ExperimentalLayoutApi::class, ExperimentalCoilApi::class)
@Composable
fun InputImageAttachmentEditor(
    modifier: Modifier = Modifier,
    isBigContent: Boolean = false,
    textStyle: TextStyle = MaterialTheme.typography.displaySmall,
    onInputEdit: (String) -> Unit,
    icons: List<ImageVector> = listOf(),
    placeholder: String,
    label: String? = null,
    contentLimit: Int = 0,
) {

    val context = LocalContext.current
    val input = remember { mutableStateOf("") }
    val attachmentIcons = listOf(
        Icons.Default.Add to "Add" to 1,
        Icons.Default.Settings to "File" to 2,
        Icons.Default.Clear to "Clear" to 3,
    )
    val selectedImages = remember {
        mutableStateOf<List<Uri>>(listOf())
    }
    val pickMultipleMedia =
        rememberLauncherForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(10)) { uris ->
            // Callback is invoked after the user selects media items or closes the
            // photo picker.
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
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (label != null) {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    style = MaterialTheme.typography.titleMedium,
                    text = label
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(8.dp),
        ) {
            LazyRow(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
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
        }
    }
}


