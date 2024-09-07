package com.saydullin.codehub.presentation.component.editor.input.item

import android.text.Editable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

interface OnInputLabelChange<T> {
    fun onAdd(item: T) {}
    fun onRemove(item: T) {}
    fun onItemChange(items: List<T>) {}
    fun onTextEdit(editable: Editable) {}
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun <T> InputLabelEditor(
    modifier: Modifier = Modifier,
    isBigContent: Boolean = false,
    suggestItemsByText: (text: String) -> List<T>,
    suggestItemComponent: @Composable (T) -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.displaySmall,
    onInputEdit: OnInputLabelChange<T>,
    icons: List<ImageVector> = listOf(),
    placeholder: String,
    label: String? = null,
    contentCharLimit: Int = 0,
    itemCountLimit: Int,
) {

    val input = remember { mutableStateOf("") }
    val suggestItems = remember { mutableStateOf<List<T>>(listOf()) }
    val selectedItems = remember { mutableStateOf<List<T>>(listOf()) }

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (label != null) {
                Text(
                    style = MaterialTheme.typography.titleMedium,
                    text = label
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            AnimatedVisibility(
                visible = input.value.isEmpty(),
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text(
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    text = "${selectedItems.value.size}/$itemCountLimit"
                )
            }
            AnimatedVisibility(
                visible = input.value.length > (contentCharLimit - 31) && input.value.isNotEmpty(),
                enter = fadeIn(),
                exit = fadeOut(),
            ) {
                Text(
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    text = "${input.value.length}/$contentCharLimit"
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(16.dp)
                ),
        ) {
            TextField(
                modifier = Modifier
                    .weight(1f)
                    .heightIn(min = if (isBigContent) 200.dp else 0.dp),
                value = input.value,
                onValueChange = {
                    if (contentCharLimit == 0 || it.length <= contentCharLimit) {
                        val items = suggestItemsByText(it)

                        suggestItems.value = items

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
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow {
            for (suggestItem in suggestItems.value) {
                suggestItemComponent(suggestItem)
            }
        }
    }
}


