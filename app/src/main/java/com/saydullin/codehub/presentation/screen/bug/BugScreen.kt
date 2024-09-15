package com.saydullin.codehub.presentation.screen.bug

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.component.bug.BugCard
import com.saydullin.codehub.presentation.component.search.ArticleSearch
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen
import com.saydullin.codehub.presentation.viewModel.PostViewModel

@Composable
fun BugScreen(
    navController: NavController = rememberNavController(),
    postViewModel: PostViewModel = hiltViewModel(),
) {

    val scrollState = rememberLazyListState()
    val postsMainResponse = postViewModel.posts.value
    val postsPaging = postsMainResponse?.data

    CodeHubScreen(
        title = null,
        appBarContent = {
            ArticleSearch(
                onActiveCallback = {}
            )
        },
        appBarModifier = Modifier
            .padding(bottom = 8.dp),
        showOnlyAppBarContent = true,
    ) {
        LazyColumn(
            state = scrollState,
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            if (postsPaging?.items != null) {
                items(postsPaging.items) { post ->
                    BugCard(
                        navController = navController,
                        post = post
                    )
                }
            } else {
                item {
                    Text(
                        text = "No Bug Articles",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }

//    Scaffold(
//        topBar = {
//            Surface(
//                shadowElevation = elevationAnimationDp.value,
//            ) {
//                Column {
//                    ArticleSearch(
//                        onActiveCallback = {}
//                    )
//                    Spacer(modifier = Modifier.padding(bottom = 16.dp))
//                }
//            }
//        }
//    ) { contentPadding ->
//        Column(
//            modifier = Modifier
//                .padding(contentPadding)
//        ) {
//            LazyColumn(
//                state = scrollState,
//                contentPadding = PaddingValues(bottom = 16.dp),
//                verticalArrangement = Arrangement.spacedBy(8.dp),
//            ) {
////                item {
//////                    BugFilter(
//////                        filterTags = listOf("Android", "Kotlin", "Java", "Coroutines", "Dagger Hilt", "Room")
//////                    )
////                    BugStatusList(
////                        onClick = {  }
////                    )
////                    Spacer(modifier = Modifier.padding(bottom = 8.dp))
////                }
//                if (bugArticles != null) {
//                    items(bugArticles) { bugArticle ->
//                        BugCard(
//                            navController = navController,
//                            bugArticle = bugArticle
//                        )
//                    }
//                } else {
//                    item {
//                        Text(
//                            text = "No Bug Articles",
//                            style = MaterialTheme.typography.titleLarge
//                        )
//                    }
//                }
//            }
//        }
//    }

}


