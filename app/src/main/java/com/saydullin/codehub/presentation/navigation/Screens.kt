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
                Search,
                Bugs,
                Blog,
                Profile,
            )
        }
    }

    object News : Screen(
        route = "news",
        title = "News",
        icon = R.drawable.home,
        activeIcon = 0,
        isActive = false,
    )
    object Blog : Screen(
        route = "blog",
        title = "Blog",
        icon = R.drawable.ic_blog,
        activeIcon = 0,
        isActive = false,
    )
    object Search : Screen(
        route = "search",
        title = "Search",
        icon = R.drawable.ic_search,
        activeIcon = 0,
        isActive = false,
    )
    object Bugs : Screen(
        route = "bugs",
        title = "Bugs",
        icon = R.drawable.ic_bug,
        activeIcon = 0,
        isActive = false,
    )
    object BugInfo : Screen(
        route = "bugInfo",
        title = "Bug Info",
        icon = R.drawable.ic_bug,
        activeIcon = 0,
        isActive = false,
    )
    object Profile : Screen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_profile,
        activeIcon = 0,
        isActive = false,
    )

}