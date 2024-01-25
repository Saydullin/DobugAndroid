package com.saydullin.codehub.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.domain.model.article.Article
import com.saydullin.codehub.domain.model.article.ArticleAuthor

@Composable
fun ArticleList(
    data: List<Article>
) {

    LazyColumn(
        contentPadding = PaddingValues(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        items(data) { item ->
            CardArticle(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                data = item,
                onClick = {  }
            )
        }
    }

}


