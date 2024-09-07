package com.saydullin.codehub.presentation.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.component.navigation.bar.BottomBar
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
fun NavController(
    navController: NavHostController = rememberNavController(),
    postViewModel: PostViewModel = hiltViewModel()
) {

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val excludedBottomBarScreens = Screen.getExcludedBottomBarScreens()
    val isExcludedForBottomBar = excludedBottomBarScreens.all { it.route != currentRoute }

    LaunchedEffect(Unit) {
        postViewModel.getAllPosts()
        postViewModel.getLocalPost()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {

//        if (isExcludedForBottomBar) {
//            BottomBar(
//                navController = navController,
//            )
//        }

        AnimatedVisibility(
            visible = isExcludedForBottomBar,
            enter = expandVertically(),
            exit = fadeOut(
                animationSpec = tween(0)
            )
        ) {
            BottomBar(
                navController = navController,
            )
        }
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
            composable(
                route = Screen.NewBug.route,
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(0)
                    )
                },
                exitTransition = {
                    fadeOut(
                        animationSpec = tween(0)
                    )
                }
            ) {
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


