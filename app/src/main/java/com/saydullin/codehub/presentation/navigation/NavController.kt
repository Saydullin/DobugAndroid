package com.saydullin.codehub.presentation.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.screen.BugInfoScreen
import com.saydullin.codehub.presentation.screen.BugScreen
import com.saydullin.codehub.presentation.screen.NewsScreen
import com.saydullin.codehub.presentation.screen.SearchScreen
import com.saydullin.codehub.presentation.viewModel.BugArticleViewModel

@Composable
fun NavController() {

    val navController = rememberNavController()
    val screens = Screen.getBottomBarScreens()
    val selectedItem = remember { mutableIntStateOf(screens.indexOf(Screen.Bugs)) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                windowInsets = WindowInsets(left = 10.dp, right = 10.dp),
                tonalElevation = 5.dp
            ) {
                screens.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Image(
                                painter = painterResource(item.icon),
                                contentDescription = item.title,
                                contentScale = ContentScale.Crop,
                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimaryContainer),
                            )
                        },
                        label = {
                            AnimatedVisibility(
                                visible = selectedItem.value == index,
                                enter = fadeIn() + expandVertically(
                                    animationSpec = tween(
                                        durationMillis = 150,
                                        easing = LinearOutSlowInEasing
                                    )
                                ),
                                exit = fadeOut() + shrinkVertically(
                                    animationSpec = tween(
                                        durationMillis = 150,
                                        easing = LinearOutSlowInEasing
                                    )
                                ),
                            ) {
                                Text(text = item.title)
                            }},
                        selected = selectedItem.value == index,
                        onClick = {
                            selectedItem.value = index
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier
                .padding(bottom = paddingValues.calculateBottomPadding()),
            navController = navController,
            startDestination = Screen.Bugs.route
        ) {
            composable(Screen.News.route) {
                NewsScreen()
            }
            composable(Screen.BugInfo.route) {
                BugInfoScreen(
                    navController = navController
                )
            }
            composable(Screen.Blog.route) {
//                Text(
//                    text = "Blog, Saydullin!"
//                )
            }
            composable(Screen.Search.route) {
                SearchScreen()
            }
            composable(Screen.Bugs.route) {
                BugScreen(
                    navController = navController
                )
            }
            composable(Screen.Profile.route) {
//                Text(
//                    text = "Profile, Saydullin!"
//                )
            }
        }
    }

}


