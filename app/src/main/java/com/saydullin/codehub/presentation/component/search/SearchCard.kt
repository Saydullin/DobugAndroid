package com.saydullin.codehub.presentation.component.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SearchCard() {

    Column {
        Card(
            modifier = Modifier
                .width(150.dp)
                .height(100.dp)
                .clickable {

                }
        ) {
//            GlideImage(
//                modifier = Modifier
//                    .fillMaxSize(),
//                contentScale = ContentScale.Crop,
//                model = "https://thispersondoesnotexist.com/",
//                contentDescription = "ops"
//            )
        }
    }

}


