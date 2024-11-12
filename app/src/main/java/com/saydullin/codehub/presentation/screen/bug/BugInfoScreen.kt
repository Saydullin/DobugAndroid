package com.saydullin.codehub.presentation.screen.bug

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen
import com.saydullin.codehub.presentation.viewModel.BugInfoViewModel
import com.saydullin.domain.util.response.Resource
import com.saydullin.domain.util.response.StatusType

@Composable
fun BugInfoScreen(
    postId: Long?,
    navController: NavController = rememberNavController(),
    postInfoViewModel: BugInfoViewModel = hiltViewModel(),
) {
    val state = remember { mutableStateOf<Resource.Error<Unit>?>(null) }
    val postInfo = postInfoViewModel.post.value

    state.value = postInfoViewModel.error.value

    LaunchedEffect(Unit) {
        if (postId == null) {
            state.value = Resource.Error(
                status = StatusType.NO_POST_INFO
            )
        } else {
            postInfoViewModel.getPostById(postId)
        }
    }

    CodeHubScreen(
        title = if (state.value != null && postInfo != null) {
            "Unknown"
        } else {
            postInfo?.title.toString()
        },
        appBarModifier = Modifier
            .padding(8.dp),
        showBackButton = true,
        onBackButtonClick = {
            navController.popBackStack()
        }
    ) {
        if (state.value != null) {
            Log.e("sady", state.value?.e.toString())
            Text(
                text = "Post Error ${state.value?.status}"
            )

            return@CodeHubScreen
        }
        if (postInfo != null) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = postInfo.description
            )
        }
    }

}


