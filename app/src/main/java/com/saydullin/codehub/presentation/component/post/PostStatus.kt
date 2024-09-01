package com.saydullin.codehub.presentation.component.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.model.bug.BugStatusType
import com.saydullin.codehub.presentation.util.BugStatusText

@Composable
fun BugStatus(
    bugStatus: BugStatusType
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
    ) {
        Text(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 10.dp, vertical = 4.dp),
            text = context.getString(BugStatusText.getText(bugStatus)),
            style = MaterialTheme.typography.labelMedium
        )
    }

}


