package com.saydullin.codehub.presentation.component.editor.input.util.item

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DefaultSuggestLabelEditor(
    title: String,
    onClick: () -> Unit
) {

    Button(
        onClick = { onClick() }
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.titleMedium
        )
    }

}