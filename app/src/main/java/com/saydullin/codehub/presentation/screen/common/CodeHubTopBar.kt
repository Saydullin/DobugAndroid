package com.saydullin.codehub.presentation.screen.common

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.util.TopBarBehavior

@Composable
fun CodeHubTopBar(
    modifier: Modifier = Modifier,
    scrollState: TopBarBehavior,
    title: String? = null,
    showOnlyContent: Boolean = false,
    showBackButton: Boolean = false,
    onBackButtonClick: () -> Unit,
    content: @Composable () -> Unit
) {

    val shadowOffset = 5.dp
    val shadowElevation = animateDpAsState(
        targetValue = if (scrollState.state.scrollOffset.dp > shadowOffset)
            shadowOffset
        else
            0.dp,
        label = ""
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shadowElevation = shadowElevation.value,
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (!showOnlyContent && title != null) {
                if (showBackButton) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            modifier = Modifier
                                .padding(0.dp),
                            onClick = { onBackButtonClick() }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.displayLarge,
                        )
                    }
                } else {
                    Text(
                        text = title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.displayLarge,
                    )
                }
            }
            content()
        }
    }

}