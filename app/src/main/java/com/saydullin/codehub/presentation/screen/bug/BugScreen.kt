package com.saydullin.codehub.presentation.screen.bug

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.domain.model.article.ArticleAuthor
import com.saydullin.codehub.domain.model.article.ArticleTag
import com.saydullin.codehub.domain.model.article.bug.BugAnswersArticle
import com.saydullin.codehub.domain.model.article.bug.BugArticle
import com.saydullin.codehub.presentation.component.ScreenTitle
import com.saydullin.codehub.presentation.component.bug.BugCard
import com.saydullin.codehub.presentation.viewModel.BugArticleViewModel
import kotlin.random.Random

@Composable
fun BugScreen(
    navController: NavController = rememberNavController(),
    restaurantViewModel: BugArticleViewModel = hiltViewModel(),
) {

    LaunchedEffect(Unit) {
        restaurantViewModel.loadBugArticles()
    }
    val bugArticles = restaurantViewModel.bugArticles.value

    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ScreenTitle(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                text = "Bugs"
            )
        }
        if (bugArticles != null) {
            items(bugArticles) { bugArticle ->
                BugCard(
                    navController = navController,
                    bugArticle = bugArticle
                )
            }
        } else {
            item {
                Text(
                    text = "No Bug Articles",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }

}


