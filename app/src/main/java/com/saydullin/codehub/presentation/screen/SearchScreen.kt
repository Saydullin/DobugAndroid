package com.saydullin.codehub.presentation.screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.component.search.ArticleSearch

@Composable
fun SearchScreen() {

    val isActive = remember { mutableStateOf(false) }
    val topMargin = animateDpAsState(
        targetValue =
        if (isActive.value) {
            0.dp
        } else {
            50.dp
        }
    )

    Column(
        modifier = Modifier
            .padding(top = topMargin.value)
            .fillMaxWidth()
    ) {
        ArticleSearch(
            onActiveCallback = {
                isActive.value = it
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .padding(16.dp),
            text = "Operation System",
            style = MaterialTheme.typography.titleLarge
        )
        SearchCategoryList()
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .padding(16.dp),
            text = "Programming language",
            style = MaterialTheme.typography.titleLarge
        )
        SearchCategoryList()
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .padding(16.dp),
            text = "Frameworks and libraries",
            style = MaterialTheme.typography.titleLarge
        )
        SearchCategoryList()
    }

}


