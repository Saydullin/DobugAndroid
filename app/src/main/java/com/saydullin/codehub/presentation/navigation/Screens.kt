package com.saydullin.codehub.presentation.navigation

import com.saydullin.codehub.R

sealed class Screen(
    val route: String,
    val title: String,
    val icon: Int,
    val activeIcon: Int,
    val isActive: Boolean,
) {

    companion object {
        fun getBottomBarScreens(): List<Screen> {
            return listOf(
                News,
                Blog,
                Search,
                Questions,
                Profile
            )
        }
    }

    object News: Screen(
        route = "news",
        title = "News",
        icon = R.drawable.home,
        activeIcon = 0,
        isActive = false,
    )
    object Blog: Screen(
        route = "blog",
        title = "Blog",
        icon = R.drawable.blog,
        activeIcon = 0,
        isActive = false,
    )
    object Search: Screen(
        route = "search",
        title = "Search",
        icon = R.drawable.search,
        activeIcon = 0,
        isActive = false,
    )
    object Questions: Screen(
        route = "my_questions",
        title = "Questions",
        icon = R.drawable.question,
        activeIcon = 0,
        isActive = false,
    )
    object Profile: Screen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.profile,
        activeIcon = 0,
        isActive = false,
    )

}