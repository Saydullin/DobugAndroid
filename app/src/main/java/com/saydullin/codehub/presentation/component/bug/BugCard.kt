package com.saydullin.codehub.presentation.component.bug

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.component.author.AuthorPreview
import com.saydullin.codehub.presentation.component.author.UnknownAuthorPreview
import com.saydullin.codehub.presentation.navigation.Screen
import com.saydullin.domain.model.post.Post

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BugCard(
    navController: NavController = rememberNavController(),
    post: Post,
) {

    val author = post.author

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable {
                navController.navigate(
                    Screen.BugInfo.route.replace(
                        "{postId}",
                        "${post.id}"
                    )
                )
            }
    ) {
        if (!post.tags.isNullOrEmpty()) {
            FlowRow(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                post.tags?.forEach { tag->
                    SuggestionChip(
                        onClick = {  },
                        label = {
                            Text(
                                text = tag.title,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = post.title,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (author != null) {
                AuthorPreview(author)
            } else {
                UnknownAuthorPreview()
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = post.description,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodySmall,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Not solved",
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.labelMedium,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "10 Aug 2023",
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
    }

}


