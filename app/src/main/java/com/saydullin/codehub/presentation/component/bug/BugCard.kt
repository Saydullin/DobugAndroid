package com.saydullin.codehub.presentation.component.bug

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.saydullin.codehub.domain.model.article.bug.BugArticle
import com.saydullin.codehub.presentation.component.ArticleTag
import com.saydullin.codehub.presentation.navigation.Screen

@OptIn(ExperimentalLayoutApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun BugCard(
    navController: NavController = rememberNavController(),
    bugArticle: BugArticle
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(Screen.BugInfo.route)
                }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                GlideImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                    model = bugArticle.previewImage,
                    contentDescription = "bug preview image"
                )
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "Add",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = bugArticle.author.nickName,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = bugArticle.title,
                        maxLines = 5,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = bugArticle.description,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(modifier = Modifier.height(16.dp))
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    for (tag in bugArticle.tags) {
                        ArticleTag(title = tag.title)
                    }
                }
            }
//            Column(
//                modifier = Modifier
//                    .padding(16.dp)
//            ) {
//
//                Spacer(modifier = Modifier.height(20.dp))
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Text(
//                        modifier = Modifier
//                            .padding(end = 10.dp),
//                        text =
//                            if (bugArticle.isFixed) {
//                                "Fixed"
//                            } else {
//                                "Not fixed yet"
//                            },
//                        style = MaterialTheme.typography.labelMedium,
//                    )
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                    ) {
//                        Icon(
//                            modifier = Modifier
//                                .width(20.dp)
//                                .height(20.dp),
//                            imageVector = Icons.Outlined.Add,
//                            contentDescription = "Add",
//                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
//                        )
//                        Spacer(modifier = Modifier.width(5.dp))
//                        Text(
//                            text = "${bugArticle.useful}",
//                            style = MaterialTheme.typography.labelMedium,
//                        )
//                        Spacer(modifier = Modifier.width(15.dp))
//                        Icon(
//                            modifier = Modifier
//                                .width(20.dp)
//                                .height(20.dp),
//                            painter = painterResource(R.drawable.ic_views),
//                            contentDescription = "Views",
//                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
//                        )
//                        Spacer(modifier = Modifier.width(5.dp))
//                        Text(
//                            text = "${bugArticle.views}",
//                            style = MaterialTheme.typography.labelMedium,
//                        )
//                        Spacer(modifier = Modifier.width(15.dp))
//                        Icon(
//                            modifier = Modifier
//                                .width(20.dp)
//                                .height(20.dp),
//                            painter = painterResource(R.drawable.ic_comments),
//                            contentDescription = "Comments",
//                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
//                        )
//                        Spacer(modifier = Modifier.width(5.dp))
//                        Text(
//                            text = "${bugArticle.answers.size}",
//                            style = MaterialTheme.typography.labelMedium,
//                        )
//                    }
//                }
//            }
        }
    }

}


