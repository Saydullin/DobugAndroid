package com.saydullin.codehub.presentation.component.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun FilterChip(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit
) {
    val selected = remember {
        mutableStateOf(false)
    }

    androidx.compose.material3.FilterChip(
        modifier = modifier,
        onClick = {
            selected.value = !selected.value
            onClick()
        },
        label = {
            Text(
                text = label,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyLarge,
            )
        },
        selected = selected.value,
        leadingIcon = {
            AnimatedVisibility(
                visible = selected.value,
                enter = fadeIn() + expandHorizontally(
                    animationSpec = tween(
                        durationMillis = 150,
                        easing = LinearOutSlowInEasing
                    )
                ),
                exit = fadeOut() + shrinkHorizontally(
                    animationSpec = tween(
                        durationMillis = 150,
                        easing = LinearOutSlowInEasing
                    )
                ),
            ) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        }
    )

}