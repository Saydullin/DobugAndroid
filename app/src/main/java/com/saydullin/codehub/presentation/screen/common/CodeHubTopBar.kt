package com.saydullin.codehub.presentation.screen.common

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.util.TopBarBehavior

@Composable
fun CodeHubTopBar(
    modifier: Modifier = Modifier,
    scrollState: TopBarBehavior,
    title: String? = null,
    showOnlyContent: Boolean = false,
    content: @Composable () -> Unit
) {

    val shadowOffset = 10.dp
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
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
            content()
        }
    }

}