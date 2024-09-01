package com.saydullin.codehub.presentation.component.post

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.component.common.FilterChip

@Composable
fun BugFilter(
    filterTags: List<String>
) {

    Column() {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filterTags) {
                FilterChip(
                    label = it,
                    onClick = {  }
                )
            }
        }
    }

}


