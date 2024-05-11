package com.saydullin.codehub.presentation.screen.notification

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.R
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen

@Composable
fun NotificationScreen(
    navController: NavController = rememberNavController()
) {
    val ctx = LocalContext.current

    CodeHubScreen(
        title = ctx.getString(R.string.notifications_title),
    ) {

    }

}