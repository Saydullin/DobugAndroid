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
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.domain.model.article.Article
import com.saydullin.codehub.presentation.screen.NewsScreen

@Composable
fun NavController(
    articles: List<Article>
) {

    val navController = rememberNavController()
    val selectedItem = remember { mutableIntStateOf(2) }
    val screens = Screen.getBottomBarScreens()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                windowInsets = WindowInsets(left = 10.dp, right = 10.dp)
            ) {
                screens.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Image(
                                painterResource(item.icon),
                                contentDescription = item.title,
                                contentScale = ContentScale.Crop,
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
            startDestination = Screen.Search.route
        ) {
            composable(Screen.News.route) {
                NewsScreen(
                    articles = articles
                )
            }
            composable(Screen.Blog.route) {
                Text(
                    text = "Blog, Saydullin!"
                )
            }
            composable(Screen.Search.route) {
                Text(
                    text = "Search, Saydullin!"
                )
            }
            composable(Screen.Questions.route) {
                Text(
                    text = "Questions, Saydullin!"
                )
            }
            composable(Screen.Profile.route) {
                Text(
                    text = "Profile, Saydullin!"
                )
            }
        }
    }

}


