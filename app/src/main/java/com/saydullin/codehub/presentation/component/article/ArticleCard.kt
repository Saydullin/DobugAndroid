package com.saydullin.codehub.presentation.component.article

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.saydullin.codehub.R
import com.saydullin.codehub.domain.model.article.news.NewsArticle

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardArticle(
    modifier: Modifier = Modifier,
    data: NewsArticle,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
        ) {
            Box(
                modifier = Modifier
            ) {
                GlideImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                    model = data.imageUrl,
                    contentDescription = data.title
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 10.dp)
            ) {
                Text(
                    text = data.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                Text(
                    text = data.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                        ) {
                            GlideImage(
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp),
                                contentScale = ContentScale.Crop,
                                model = data.author.profileImageUrl,
                                contentDescription = data.author.firstName,
                            )
                        }
                        Spacer(
                            modifier = Modifier.width(10.dp)
                        )
                        Text(
                            text = data.author.nickName,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                                .alpha(.5f),
                            painter = painterResource(R.drawable.ic_views),
                            contentDescription = stringResource(R.string.views_cd),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Spacer(
                            modifier = Modifier.width(5.dp)
                        )
                        Text(
                            text = "${data.views}",
                            style = MaterialTheme.typography.labelMedium
                        )
                        Spacer(
                            modifier = Modifier.width(15.dp)
                        )
                        Icon(
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                                .alpha(.5f),
                            painter = painterResource(R.drawable.ic_comments),
                            contentDescription = stringResource(R.string.comments_cd),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                        Spacer(
                            modifier = Modifier.width(5.dp)
                        )
                        Text(
                            text = "${data.comments.size}",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }

}


