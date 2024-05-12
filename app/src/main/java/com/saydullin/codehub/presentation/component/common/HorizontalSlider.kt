package com.saydullin.codehub.presentation.component.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.R

@Composable
fun HorizontalSlider(
    title: String,
    showFullButton: Boolean = false,
    onFullButtonClick: () -> Unit,
    content: @Composable () -> Unit
) {

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.displayMedium
            )
            if (showFullButton) {
                IconButton(
                    onClick = { onFullButtonClick() }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                        contentDescription = stringResource(R.string.full_view_cd),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        content()
    }

}


