package com.saydullin.codehub.presentation.screen.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.R
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen

@Composable
fun ProfileScreen(
    navController: NavController = rememberNavController()
) {
    val ctx = LocalContext.current

    CodeHubScreen(
        title = ctx.getString(R.string.profile_title),
        appBarModifier = Modifier
            .padding(16.dp)
    ) {

    }

}


