package com.saydullin.codehub.presentation.screen.profile

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.saydullin.codehub.presentation.component.author.UserBugsSlider

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProfileAuthScreen() {

    val profileImageHeight = 70.dp

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
    ) {
        GlideImage(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
            model = "https://t4.ftcdn.net/jpg/05/71/83/47/360_F_571834789_ujYbUnH190iUokdDhZq7GXeTBRgqYVwa.jpg",
            contentDescription = "background"
        )
        Column(
            modifier = Modifier
                .offset(
                    y = profileImageHeight
                        .div(2)
                        .times(-1f)
                )
                .zIndex(1f)
                .padding(horizontal = 16.dp)
        ) {
            GlideImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .height(profileImageHeight)
                    .width(profileImageHeight)
                    .border(
                        2.dp,
                        MaterialTheme.colorScheme.background,
                        RoundedCornerShape(20.dp),
                    ),
                contentScale = ContentScale.Crop,
                model = "https://thispersondoesnotexist.com",
                contentDescription = "Author"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Nicola Tesla",
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Android Developer",
                style = MaterialTheme.typography.titleMedium
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            UserBugsSlider(
                bugsList = listOf("Hello", "World", "Saydullin", "Hello", "World", "Saydullin", "Hello", "World", "Saydullin", "Hello", "World", "Saydullin"),
                showFullButton = true,
                onFullButtonClick = {  },
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            UserBugsSlider(
                bugsList = listOf("Hello", "World", "Saydullin", "Hello", "World", "Saydullin", "Hello", "World", "Saydullin", "Hello", "World", "Saydullin"),
                showFullButton = true,
                onFullButtonClick = {  },
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            UserBugsSlider(
                bugsList = listOf("Hello", "World", "Saydullin", "Hello", "World", "Saydullin", "Hello", "World", "Saydullin", "Hello", "World", "Saydullin"),
                showFullButton = true,
                onFullButtonClick = {  },
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            UserBugsSlider(
                bugsList = listOf("Hello", "World", "Saydullin", "Hello", "World", "Saydullin", "Hello", "World", "Saydullin", "Hello", "World", "Saydullin"),
                showFullButton = true,
                onFullButtonClick = {  },
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            UserBugsSlider(
                bugsList = listOf("Hello", "World", "Saydullin", "Hello", "World", "Saydullin", "Hello", "World", "Saydullin", "Hello", "World", "Saydullin"),
                showFullButton = true,
                onFullButtonClick = {  },
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            UserBugsSlider(
                bugsList = listOf("Hello", "World", "Saydullin", "Hello", "World", "Saydullin", "Hello", "World", "Saydullin", "Hello", "World", "Saydullin"),
                showFullButton = true,
                onFullButtonClick = {  },
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }

}