package com.saydullin.codehub.presentation.screen.blog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.component.ScreenTitle

@Composable
fun BlogScreen(
    navController: NavController = rememberNavController()
) {

    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
    ) {
        ScreenTitle(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = "Blog"
        )
    }

}