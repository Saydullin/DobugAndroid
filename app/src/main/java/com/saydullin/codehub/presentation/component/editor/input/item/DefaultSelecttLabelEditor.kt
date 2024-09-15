package com.saydullin.codehub.presentation.component.editor.input.item

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable

@Composable
fun DefaultSelectLabelEditor(
    title: String,
    onClick: () -> Unit,
) {

    Button(
        onClick = { onClick() }
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleMedium
        )
    }

}