package com.saydullin.codehub.presentation.screen.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.saydullin.codehub.presentation.component.bug.ShortBugCard
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen
import com.saydullin.codehub.presentation.viewModel.BugArticleViewModel
import com.saydullin.codehub.presentation.viewModel.ProfileViewModel

@OptIn(ExperimentalGlideComposeApi::class,
    ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class
)
@Composable
fun ProfileScreen(
    navController: NavController = rememberNavController(),
    profileViewModel: ProfileViewModel = hiltViewModel(),
    restaurantViewModel: BugArticleViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        restaurantViewModel.loadBugArticles()
    }
    val ctx = LocalContext.current
    val profile = profileViewModel.profileData.value
    val tabIndex = remember { mutableStateOf(0) }
    val titles = listOf("Posts", "Resolving", "Followers")
    val scrollState = rememberLazyListState()
    val bugArticles = restaurantViewModel.bugArticles.value

    CodeHubScreen(
//            title = ctx.getString(R.string.profile_title),
        title = "Emily Anderson",
        appBarModifier = Modifier
            .padding(16.dp),
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GlideImage(
                        modifier = Modifier
                            .height(75.dp)
                            .width(75.dp)
                            .clip(RoundedCornerShape(15.dp)),
                        contentScale = ContentScale.Crop,
                        model = "https://thispersondoesnotexist.com",
                        contentDescription = "bug preview image"
                    )
                    Spacer(modifier = Modifier.width(32.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = "36",
                                style = MaterialTheme.typography.displayMedium,
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = "Posts",
                                color = MaterialTheme.colorScheme.outline,
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = "212",
                                style = MaterialTheme.typography.displayMedium,
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = "Resolved",
                                color = MaterialTheme.colorScheme.outline,
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = "2.3K",
                                style = MaterialTheme.typography.displayMedium,
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = "Followers",
                                color = MaterialTheme.colorScheme.outline,
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
//                Text(
//                    modifier = Modifier
//                        .padding(horizontal = 16.dp),
//                    text = "Emily Anderson",
//                    style = MaterialTheme.typography.bodyLarge,
//                )
//                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    text = "IOS Developer",
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    text = "Passionate IOS Developer creating innovative experiences with attention to detail.",
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            stickyHeader {
                PrimaryTabRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    selectedTabIndex = tabIndex.value
                ) {
                    titles.forEachIndexed { index, title ->
                        Tab(
                            selected = tabIndex.value == index,
                            onClick = { tabIndex.value = index },
                            text = {
                                Text(
                                    text = title
                                )
                            }
                        )
                    }
                }
            }
            if (bugArticles != null) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                }
                items(bugArticles) { bugArticle ->
                    Spacer(modifier = Modifier.height(8.dp))
                    ShortBugCard(
                        navController = navController,
                        bugArticle = bugArticle
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            } else {
                item {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        text = "No Bug Articles",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}


