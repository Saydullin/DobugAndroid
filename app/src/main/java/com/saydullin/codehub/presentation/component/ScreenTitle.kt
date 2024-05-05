package com.saydullin.codehub.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ScreenTitle(
    modifier: Modifier = Modifier,
    text: String
) {

    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineSmall
    )

}


