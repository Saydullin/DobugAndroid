package com.saydullin.codehub.presentation.component

import androidx.compose.foundation.Image
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
import com.saydullin.codehub.domain.model.article.Article

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardArticle(
    modifier: Modifier = Modifier,
    data: Article,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .clickable { onClick() }
        ) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
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
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                Text(
                    text = data.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelMedium
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
                        Text(
                            text = data.author.nickName,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                                .alpha(.5f),
                            painter = painterResource(R.drawable.views),
                            contentDescription = stringResource(R.string.views_cd),
                            contentScale = ContentScale.Crop,
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
                        Image(
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                                .alpha(.5f),
                            painter = painterResource(R.drawable.comments),
                            contentDescription = stringResource(R.string.comments_cd),
                            contentScale = ContentScale.Crop,
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


