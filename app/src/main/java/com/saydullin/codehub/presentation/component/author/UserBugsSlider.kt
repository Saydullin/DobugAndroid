package com.saydullin.codehub.presentation.component.author

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.component.common.HorizontalSlider

@Composable
fun UserBugsSlider(
    bugsList: List<String>,
    showFullButton: Boolean = false,
    onFullButtonClick: () -> Unit,
) {

    HorizontalSlider(
        title = "Bugs",
        showFullButton = showFullButton,
        onFullButtonClick = { onFullButtonClick() }
    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(bugsList) {
                Card(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Text(
                        modifier = Modifier
                            .padding(16.dp),
                        text = it,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }

}