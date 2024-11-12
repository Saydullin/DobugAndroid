package com.saydullin.codehub.presentation.screen.newBug

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.component.editor.post.ui.PostEditor
import com.saydullin.codehub.presentation.component.editor.post.model.PostEditorTextSetting
import com.saydullin.codehub.presentation.model.post.PostUI
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen
import com.saydullin.codehub.presentation.viewModel.NewPostViewModel
import com.saydullin.codehub.presentation.viewModel.PostViewModel
import com.saydullin.codehub.presentation.viewModel.TagViewModel

@Composable
fun NewBugScreen(
    navController: NavController = rememberNavController(),
    newPostViewModel: NewPostViewModel = hiltViewModel(),
    postViewModel: PostViewModel = hiltViewModel(),
    tagViewModel: TagViewModel = hiltViewModel(),
) {
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }

    val tags = tagViewModel.tags.value

    DisposableEffect(Unit) {
        title.value = newPostViewModel.title.value
        description.value = newPostViewModel.description.value

        onDispose {
            newPostViewModel.setTitle(title.value)
            newPostViewModel.setDescription(description.value)
        }
    }

    CodeHubScreen(
        showBackButton = true,
        onBackButtonClick = { navController.popBackStack() },
        showOnlyAppBarContent = false,
        title = "New post",
        appBarModifier = Modifier
            .padding(vertical = 16.dp, horizontal = 8.dp)
    ) {
        PostEditor(
            titleDefault = title.value,
            onTitleEdit = { title.value = it },
            contentDefault = description.value,
            onContentEdit = { description.value = it },
            onAttachmentEdit = {  },
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
            onSubmit = {
                val postUI = PostUI(
                    previewImages = listOf(),
                    title = title.value,
                    description = description.value,
                    attachments = listOf(),
                    tags = listOf(),
                    type = "Android",
                    status = "Open"
                )

                postViewModel.savePost(postUI)
            }
        ) {
            if (tags != null) {
                items(tags) {
                    Card(
                        onClick = {  }
                    ) {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = it.title
                        )
                    }
                }
            }
        }
    }

}