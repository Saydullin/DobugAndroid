package com.saydullin.codehub.presentation.navigation

import android.util.Log
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.screen.blog.BlogScreen
import com.saydullin.codehub.presentation.screen.bug.BugInfoScreen
import com.saydullin.codehub.presentation.screen.bug.BugScreen
import com.saydullin.codehub.presentation.screen.favoruite.FavouriteScreen
import com.saydullin.codehub.presentation.screen.newBug.NewBugScreen
import com.saydullin.codehub.presentation.screen.news.NewsScreen
import com.saydullin.codehub.presentation.screen.notification.NotificationScreen
import com.saydullin.codehub.presentation.screen.profile.ProfileScreen
import com.saydullin.codehub.presentation.screen.projects.ProjectsScreen
import com.saydullin.codehub.presentation.screen.search.SearchScreen
import com.saydullin.codehub.presentation.viewModel.PostViewModel

@Composable
fun NavController() {

    val selectedRoute = remember {
        mutableStateOf(Screen.Bugs.route)
    }
    val navController = rememberNavController()
    val postViewModel: PostViewModel = hiltViewModel()
    val screens = Screen.getBottomBarScreens()

    LaunchedEffect(Unit) {
        Log.e("sady", "Getting All Posts")
        postViewModel.getAllPosts()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
                windowInsets = WindowInsets(left = 8.dp),
                actions = {
                    screens.forEach { item ->
                        val isSelected = selectedRoute.value == item.route
                        IconButton(onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id)
                            }
                            selectedRoute.value = item.route
                        }) {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.title,
                                tint = if (isSelected) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.onSurface
                                }
                            )
                        }
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            navController.navigate(Screen.NewBug.route) {
                                popUpTo(navController.graph.findStartDestination().id)
                            }
                            selectedRoute.value = Screen.NewBug.route
                        },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        NavHost(
            modifier = Modifier
                .padding(innerPadding),
            navController = navController,
            startDestination = Screen.Bugs.route
        ) {
            composable(Screen.News.route) {
                NewsScreen(
                    navController = navController
                )
            }
            composable(Screen.BugInfo.route) {
                BugInfoScreen(
                    navController = navController
                )
            }
            composable(Screen.Blog.route) {
                BlogScreen(
                    navController = navController
                )
            }
            composable(Screen.Search.route) {
                SearchScreen(
                    navController = navController
                )
            }
            composable(Screen.Bugs.route) {
                BugScreen(
                    navController = navController,
                    postViewModel = postViewModel,
                )
            }
            composable(Screen.NewBug.route) {
                NewBugScreen(
                    navController = navController
                )
            }
            composable(Screen.Projects.route) {
                ProjectsScreen(
                    navController = navController
                )
            }
            composable(Screen.Favourite.route) {
                FavouriteScreen(
                    navController = navController
                )
            }
            composable(Screen.Notifications.route) {
                NotificationScreen(
                    navController = navController
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen(
                    navController = navController
                )
            }
            composable(Screen.BugInfo.route) {
                BugInfoScreen(
                    navController = navController
                )
            }
        }
    }

}


