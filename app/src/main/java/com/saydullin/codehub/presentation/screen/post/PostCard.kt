package com.saydullin.codehub.presentation.screen.post

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.domain.model.post.Post

@Composable
fun PostCard(
    navController: NavController = rememberNavController(),
    post: Post
) {

    Text(
        modifier = Modifier
            .fillMaxWidth(),
        text = post.title,
        style = MaterialTheme.typography.titleLarge
    )

}