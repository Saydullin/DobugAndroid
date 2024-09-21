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
                Bugs,
                Projects,
                Favourite,
                Notifications,
                Profile,
            )
        }

        fun getExcludedBottomBarScreens(): List<Screen> {
            return listOf(
                NewBug
            )
        }
    }

    data object SignedInScreen : Screen(
        route = "signed_in_screen",
        title = "Signed In",
        icon = R.drawable.ic_profile,
        activeIcon = 0,
        isActive = false,
    )
    data object News : Screen(
        route = "news",
        title = "News",
        icon = R.drawable.home,
        activeIcon = 0,
        isActive = false,
    )
    data object Notifications : Screen(
        route = "motifications",
        title = "Notifications",
        icon = R.drawable.ic_notifications,
        activeIcon = 0,
        isActive = false,
    )
    data object Projects : Screen(
        route = "projects",
        title = "Projects",
        icon = R.drawable.ic_projects,
        activeIcon = 0,
        isActive = false,
    )
    data object Favourite : Screen(
        route = "favourite",
        title = "Favourite",
        icon = R.drawable.ic_favorite,
        activeIcon = 0,
        isActive = false,
    )
    data object Blog : Screen(
        route = "blog",
        title = "Blog",
        icon = R.drawable.ic_blog,
        activeIcon = 0,
        isActive = false,
    )
    data object Search : Screen(
        route = "search",
        title = "Search",
        icon = R.drawable.ic_search,
        activeIcon = 0,
        isActive = false,
    )
    data object Bugs : Screen(
        route = "bugs",
        title = "Bugs",
        icon = R.drawable.ic_bug,
        activeIcon = 0,
        isActive = false,
    )
    data object NewBug : Screen(
        route = "new_bug",
        title = "New bug",
        icon = R.drawable.ic_add,
        activeIcon = 0,
        isActive = false,
    )
    data object BugInfo : Screen(
        route = "bugInfo",
        title = "Bug Info",
        icon = R.drawable.ic_bug,
        activeIcon = 0,
        isActive = false,
    )
    data object Profile : Screen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_profile,
        activeIcon = 0,
        isActive = false,
    )

}


