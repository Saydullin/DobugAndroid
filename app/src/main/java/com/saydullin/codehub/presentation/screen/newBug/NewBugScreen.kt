package com.saydullin.codehub.presentation.screen.newBug

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.R
import com.saydullin.codehub.presentation.component.editor.InputCodeEditor
import com.saydullin.codehub.presentation.component.editor.InputEditor
import com.saydullin.codehub.presentation.model.post.PostUI
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen
import com.saydullin.codehub.presentation.viewModel.PostViewModel
import com.saydullin.domain.model.post.Post

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
                textStyle = MaterialTheme.typography.titleLarge,
                onInputEdit = { titlePost.value = it },
                label = "Title. Write a few words about it",
                placeholder = "Short naming of your bug",
                contentLimit = 100,
            )
            Spacer(modifier = Modifier.height(16.dp))
            InputEditor(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                textStyle = MaterialTheme.typography.titleLarge,
                onInputEdit = { descriptionPost.value = it },
                isBigContent = true,
                label = "Description. Write more about this",
                placeholder = "Where? How? When? ...",
                contentLimit = 1000,
            )
            Spacer(modifier = Modifier.height(16.dp))
            InputCodeEditor(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                textStyle = MaterialTheme.typography.titleLarge,
                onInputEdit = {},
                icons = listOf(Icons.Default.Add, Icons.Default.Call, Icons.Default.Check),
                label = "Attachments. Paste code, text and etc",
                placeholder = "class Activity : AppCompatActivity() { ...",
                contentLimit = 1000,
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
                                title = titlePost.value,
                                description = descriptionPost.value
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