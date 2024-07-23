package com.saydullin.codehub.presentation.component.projects

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.component.author.AuthorPreview
import com.saydullin.codehub.presentation.component.common.ArticleTag
import com.saydullin.codehub.presentation.model.project.Project

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectCard(
    modifier: Modifier = Modifier,
    project: Project,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = project.title,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = project.description,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            AuthorPreview(
                author = project.author
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Looking for:",
                style = MaterialTheme.typography.bodySmall
            )
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                for (tag in project.tags) {
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
    }

}


