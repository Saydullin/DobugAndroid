package com.saydullin.codehub.presentation.component.article

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.domain.model.article.news.NewsArticle

@Composable
fun ArticleList() {

    val articles = remember { mutableStateOf<List<NewsArticle>>(listOf()) }

    LazyColumn(
        contentPadding = PaddingValues(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        items(articles.value) { item ->
            CardArticle(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                data = item,
                onClick = {  }
            )
        }
    }

}


