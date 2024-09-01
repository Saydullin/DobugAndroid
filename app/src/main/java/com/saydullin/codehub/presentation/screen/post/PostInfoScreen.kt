package com.saydullin.codehub.presentation.screen.post

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen

@Composable
fun BugInfoScreen(
    navController: NavController = rememberNavController()
) {

    CodeHubScreen(
        title = "Bug Info",
        appBarModifier = Modifier
            .padding(8.dp),
        showBackButton = true,
        onBackButtonClick = {
            navController.popBackStack()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(100) {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = "Hello Saydullin"
                )
            }
        }
    }

}


