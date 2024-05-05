package com.saydullin.codehub.presentation.screen.news

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.component.article.ArticleList

@Composable
fun NewsScreen(
    navController: NavController = rememberNavController()
) {

    Column {
        ArticleList()
    }

}


