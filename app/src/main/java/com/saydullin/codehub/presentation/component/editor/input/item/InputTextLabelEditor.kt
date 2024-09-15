package com.saydullin.codehub.presentation.component.editor.input.item

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.component.editor.model.InputTextLabel
import com.saydullin.domain.ext.toggle

@Composable
fun InputTextLabelEditor(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    isBigContent: Boolean = false,
    items: List<InputTextLabel>,
    onTextEdit: (text: String) -> Unit,
    onItemSelected: (item: InputTextLabel) -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.displaySmall,
    icons: List<ImageVector> = listOf(),
    placeholder: String,
    label: String? = null,
    contentCharLimit: Int = 0,
    itemCountLimit: Int,
) {

    val input = remember { mutableStateOf("") }
    val suggestItems = remember { mutableStateListOf(*items.toTypedArray()) }
    val selectItems = remember { mutableStateListOf<InputTextLabel>() }

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (label != null) {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    text = label
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                text = "${selectItems.size}/$itemCountLimit"
            )
            AnimatedVisibility(
                visible = input.value.length > (contentCharLimit - 5) && input.value.isNotEmpty(),
                enter = expandHorizontally() + fadeIn(),
                exit = shrinkHorizontally() + fadeOut(),
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    text = "${input.value.length}/$contentCharLimit"
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        AnimatedVisibility(
            visible = suggestItems.isNotEmpty(),
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            LazyRow(
                contentPadding = PaddingValues(start = 16.dp, end = 8.dp),
            ) {
                items(suggestItems) {
                    InputTextLabelSuggestChip(
                        item = it,
                        onClick = {
                            selectItems.toggle(it)
                            onItemSelected(it)
                        }
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .padding(contentPadding)
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(16.dp)
                ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = if (isBigContent) 200.dp else 0.dp),
                    value = input.value,
                    onValueChange = {
                        if (contentCharLimit == 0 || it.length <= contentCharLimit) {
                            onTextEdit(it)

                            input.value = it
                        }
                    },
                    placeholder = {
                        Text(
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.outline,
                            text = placeholder,
                        )
                    },
                    shape = RoundedCornerShape(16.dp),
                    textStyle = textStyle,
                    label = null,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                    ),
                )
                if (icons.isNotEmpty()) {
                    Column {
                        icons.forEach {
                            IconButton(
                                onClick = { /*TODO*/ }
                            ) {
                                Icon(
                                    imageVector = it,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.outline,
                                )
                            }
                        }
                    }
                }
            }
            AnimatedVisibility(
                visible = suggestItems.isNotEmpty(),
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                LazyRow(
                    contentPadding = PaddingValues(start = 8.dp, top = 0.dp, bottom = 0.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(selectItems) {
                        InputTextLabelSelectChip(
                            item = it,
                            onClick = {
                                selectItems.toggle(it)
                            }
                        )
                    }
                }
            }
        }

    }
}


