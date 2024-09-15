package com.saydullin.codehub.presentation.component.editor.input.item

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.component.editor.model.InputTextLabel

@Composable
fun InputTextLabelSuggestChip(
    item: InputTextLabel,
    onClick: () -> Unit
) {

    val isVisible = remember { mutableStateOf(true) }

    AnimatedVisibility(
        modifier = Modifier
            .padding(0.dp),
        visible = isVisible.value,
        enter = expandHorizontally(
            animationSpec = tween(
                delayMillis = 300,
            )
        ),
        exit = shrinkHorizontally(
            animationSpec = tween(
                delayMillis = 300,
            )
        ),
    ) {
        AnimatedVisibility(
            visible = isVisible.value,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            SuggestionChip(
                modifier = Modifier
                    .padding(end = 8.dp),
                onClick = {
                    isVisible.value = false
                    onClick()
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            )
        }
    }

}