package com.saydullin.codehub.presentation.component.bug

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.R
import com.saydullin.codehub.presentation.component.ArticleTag

@Composable
fun BugFilter(
    filterTags: List<String>
) {

    val context = LocalContext.current
    val preText = context.getString(R.string.app_name)

    Column(
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            item {
                Text(
                    text = preText
                )
            }
            items(filterTags) {
                ArticleTag(
                    title = it,
                    onClick = {  }
                )
            }
        }
    }

}