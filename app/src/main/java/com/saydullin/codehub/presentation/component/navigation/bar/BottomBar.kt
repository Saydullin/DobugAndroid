package com.saydullin.codehub.presentation.component.navigation.bar

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.navigation.Screen

@Composable
fun BottomBar(
    navController: NavController = rememberNavController(),
) {

    val screens = Screen.getBottomBarScreens()
    val selectedRoute = remember {
        mutableStateOf(Screen.Bugs.route)
    }

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
                    val route = Screen.Search.route
                    navController.navigate(Screen.Search.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                    }
                    selectedRoute.value = route
                },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Localized description"
                )
            }
        }
    )

}