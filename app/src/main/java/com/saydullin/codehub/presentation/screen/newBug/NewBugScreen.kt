package com.saydullin.codehub.presentation.screen.newBug

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.saydullin.codehub.presentation.component.editor.post.ui.PostEditor
import com.saydullin.codehub.presentation.component.editor.post.model.PostEditorTextSetting
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen
import com.saydullin.codehub.presentation.viewModel.PostViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun NewBugScreen(
    navController: NavController = rememberNavController(),
    postViewModel: PostViewModel = hiltViewModel(),
) {
    val ctx = LocalContext.current
    val scrollState = rememberScrollState()
    val titlePost = remember { mutableStateOf("") }
    val descriptionPost = remember { mutableStateOf("") }
    val imageUrl = "https://c4.wallpaperflare.com/wallpaper/297/22/531/lake-blue-moonlight-moon-wallpaper-preview.jpg"
    val previewPostImage = remember { mutableStateOf<Uri?>(Uri.parse(imageUrl)) }

    val pickPreviewImage = rememberLauncherForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        previewPostImage.value = uri
    }

    val error = postViewModel.error.value

    if (error != null) {
        Toast.makeText(ctx, "Error $error", Toast.LENGTH_SHORT).show()
    }

    CodeHubScreen(
        showBackButton = true,
        onBackButtonClick = { navController.popBackStack() },
        showOnlyAppBarContent = false,
        title = "New post",
        appBarModifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        PostEditor(
            onTitleEdit = {  },
            onContentEdit = {  },
            onAttachmentEdit = {  },
            header = {
//                    if (previewPostImage.value != null) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clickable {
                                pickPreviewImage.launch(
                                    PickVisualMediaRequest(
                                        ActivityResultContracts.PickVisualMedia.ImageOnly
                                    )
                                )
                            },
                        contentScale = ContentScale.Crop,
                        painter = rememberImagePainter(previewPostImage.value),
                        contentDescription = "preview image"
                    )
//                    }
            },
            titleSetting = PostEditorTextSetting(
                placeholder = "Post Title",
                count = 100,
                style = MaterialTheme.typography.displayLarge
            ),
            descriptionSetting = PostEditorTextSetting(
                placeholder = "Post Description",
                count = 5000,
                style = MaterialTheme.typography.displaySmall
            ),
            onSubmit = {  }
        )
    }

}