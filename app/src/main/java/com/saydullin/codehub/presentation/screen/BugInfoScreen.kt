package com.saydullin.codehub.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.domain.model.article.bug.BugArticle

@Composable
fun BugInfoScreen(
    navController: NavController = rememberNavController()
) {
    val bugArticle: BugArticle? = null

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = bugArticle?.title ?: "null title",
            style = MaterialTheme.typography.titleLarge,
        )
    }

}


