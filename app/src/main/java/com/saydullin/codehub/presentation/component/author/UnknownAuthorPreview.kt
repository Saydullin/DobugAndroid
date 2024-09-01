package com.saydullin.codehub.presentation.component.author

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.saydullin.domain.model.post.Author

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UnknownAuthorPreview(

) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .height(24.dp)
                .width(24.dp),
            contentScale = ContentScale.Crop,
            model = "https://thispersondoesnotexist.com",
            contentDescription = "Author"
        )
    }

}


