package com.saydullin.codehub.presentation.screen.newBug.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.component.editor.input.item.InputTextLabelEditor
import com.saydullin.codehub.presentation.component.editor.model.InputTextLabel
import com.saydullin.domain.ext.filterFrom

@Composable
fun InputLabelEditorContainer() {

    val testList = listOf(
        InputTextLabel(
            id = 1,
            title = "Android",
            description = "About Android",
        ),
        InputTextLabel(
            id = 2,
            title = "Web",
            description = "About Web",
        ),
        InputTextLabel(
            id = 3,
            title = "Windows",
            description = "About Windows",
        ),
        InputTextLabel(
            id = 1,
            title = "Android",
            description = "About Android",
        ),
        InputTextLabel(
            id = 2,
            title = "Web",
            description = "About Web",
        ),
        InputTextLabel(
            id = 3,
            title = "Windows",
            description = "About Windows",
        ),
    )
    val items = remember { mutableStateListOf(*testList.toTypedArray()) }
    val suggestItems = remember { mutableStateListOf<InputTextLabel>() }
    val selectItems = remember { mutableStateListOf<InputTextLabel>() }

    InputTextLabelEditor(
        label = "Select some labels for your post some labels for your post",
        contentPadding = PaddingValues(horizontal = 16.dp),
        onTextEdit = { text ->
            suggestItems.filterFrom(items) { it.title.lowercase() == text.lowercase() }
        },
        items = items,
        onItemSelected = {  },
        placeholder = "Labels for tags",
        itemCountLimit = 6,
        contentCharLimit = 20,
    )

}