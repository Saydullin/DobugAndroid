package com.saydullin.codehub.presentation.screen.newBug

import android.text.Editable
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.R
import com.saydullin.codehub.presentation.component.editor.input.attachment.InputAttachmentEditor
import com.saydullin.codehub.presentation.component.editor.input.item.InputLabelEditor
import com.saydullin.codehub.presentation.component.editor.input.item.OnInputLabelChange
import com.saydullin.codehub.presentation.component.editor.input.primary.InputEditor
import com.saydullin.codehub.presentation.model.post.PostUI
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen
import com.saydullin.codehub.presentation.viewModel.PostViewModel

@Composable
fun NewBugScreen(
    navController: NavController = rememberNavController(),
    postViewModel: PostViewModel = hiltViewModel(),
) {
    val ctx = LocalContext.current
    val scrollState = rememberScrollState()
    val titlePost = remember { mutableStateOf("") }
    val descriptionPost = remember { mutableStateOf("") }

    CodeHubScreen(
        title = ctx.getString(R.string.newBug_title),
        appBarModifier = Modifier
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            InputEditor(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                textStyle = MaterialTheme.typography.displaySmall,
                onInputEdit = { titlePost.value = it },
                label = "Title. Write a few words about it",
                placeholder = "Short naming of your bug",
                contentLimit = 100,
            )
            Spacer(modifier = Modifier.height(16.dp))
            InputEditor(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                textStyle = MaterialTheme.typography.displaySmall,
                onInputEdit = { descriptionPost.value = it },
                isBigContent = true,
                label = "Description. Write more about this",
                placeholder = "Where? How? When? ...",
                contentLimit = 1000,
            )
            Spacer(modifier = Modifier.height(16.dp))
            InputAttachmentEditor(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                textStyle = MaterialTheme.typography.displaySmall,
                onInputEdit = {},
                icons = listOf(Icons.Default.Add, Icons.Default.Call, Icons.Default.Check),
                label = "Attachments. Paste code, text and etc",
                placeholder = "class Activity : AppCompatActivity() { ...",
                contentLimit = 1000,
            )
            Spacer(modifier = Modifier.height(16.dp))
            InputLabelEditor(
                label = "Select some labels for your post",
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                suggestItemsByText = {
                    listOf("Hello world", "My friend", "lets see", "who will die", "first")
                },
                suggestItemComponent = {
                    Text(
                        modifier = Modifier
                            .padding(16.dp)
                            .background(Color.Magenta),
                        text = it,
                    )
                },
                onInputEdit = object : OnInputLabelChange<String> {
                    override fun onAdd(item: String) {
                        super.onAdd(item)

                        Toast.makeText(ctx, "Added $item", Toast.LENGTH_SHORT).show()
                    }
                },
                placeholder = "Labels for tags",
                itemCountLimit = 6,
                contentCharLimit = 200,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Button(
                    onClick = {
                        postViewModel.savePost(
                            PostUI(
                                previewImages = listOf(),
                                title = titlePost.value,
                                description = descriptionPost.value,
                                tags = listOf(),
                                attachments = listOf(),
                                type = "",
                                status = "",
                            )
                        )
                    }
                ) {
                    Text(text = "Publish")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}