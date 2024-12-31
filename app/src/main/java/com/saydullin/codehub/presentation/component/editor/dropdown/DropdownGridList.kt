package com.saydullin.codehub.presentation.component.editor.dropdown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DropdownGridList(
    modifier: Modifier = Modifier,
    placeholder: String,
    onSearch: (text: String) -> Unit,
    items: List<String>,
) {

    val search = remember { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        FlowRow(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items.sorted().forEach {
                FilterChip(
                    label = {
                        Text(
                            text = it
                        )
                    },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
            }
        }
        TextField(
            value = search.value,
            onValueChange = {
                search.value = it
                onSearch(it)
            },
            placeholder = {
                Text(
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline,
                    text = placeholder,
                )
            },
            textStyle = MaterialTheme.typography.displaySmall,
            label = null,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
            )
        )
    }


}