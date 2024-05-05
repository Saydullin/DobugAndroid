package com.saydullin.codehub.presentation.component.bug

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.model.bug.BugStatus
import com.saydullin.codehub.presentation.util.BugStatusText

@Composable
fun BugStatus(
    bugStatus: BugStatus
) {

    val context = LocalContext.current
    val stringRes = BugStatusText.getText(bugStatus)

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 3.dp),
            text = context.getString(stringRes),
            style = MaterialTheme.typography.labelMedium
        )
    }

}


