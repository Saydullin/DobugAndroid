package com.saydullin.codehub.presentation.screen.post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen
import com.saydullin.codehub.presentation.viewModel.PostViewModel

@Composable
fun BugInfoScreen(
    navController: NavController = rememberNavController(),
    postViewModel: PostViewModel = hiltViewModel(),
) {

    val currentPost = postViewModel.currentPost.value

    if (currentPost == null) {
        NoPostFound()

        return
    }

    val title = currentPost.title
    val description = currentPost.description
    val previewImage = currentPost.previewImage

    CodeHubScreen(
        title = "Bug Info",
        appBarModifier = Modifier
            .padding(8.dp),
        showBackButton = true,
        onBackButtonClick = {
            navController.popBackStack()
        }
    ) {

        Column {
            Text(
                text = title,
            )
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                model = previewImage,
                contentDescription = ""
            )
            Text(
                text = description,
            )
        }
    }

}


