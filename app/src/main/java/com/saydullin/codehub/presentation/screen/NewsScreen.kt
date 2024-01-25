package com.saydullin.codehub.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.saydullin.codehub.domain.model.article.Article
import com.saydullin.codehub.presentation.component.ArticleList
import com.saydullin.codehub.presentation.component.ArticleSearch

@Composable
fun NewsScreen(
    articles: List<Article>
) {

    Column {
        ArticleSearch()
        ArticleList(
            data = articles
        )
    }

}


