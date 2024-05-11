package com.saydullin.codehub.presentation.component.bug

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.R
import com.saydullin.codehub.presentation.component.common.FilterChip
import com.saydullin.codehub.presentation.model.bug.BugStatusType
import com.saydullin.codehub.presentation.util.BugStatusText

@Composable
fun BugStatusList(
    onClick: (BugStatusType) -> Unit,
) {
    val context = LocalContext.current
    val statuses = listOf(
        BugStatusType.OPEN,
        BugStatusType.SOLVED,
        BugStatusType.CLOSED,
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items(statuses) {
            FilterChip(
                label = context.getString(BugStatusText.getText(it)),
                onClick = { onClick(it) }
            )
        }
        item {
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "tune"
                )
            }
        }
    }

}