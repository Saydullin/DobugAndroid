package com.saydullin.codehub.presentation.component

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleSearch() {

    val context = LocalContext.current
    val query = remember { mutableStateOf("") }
    val isActive = remember { mutableStateOf(false) }

    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        query = query.value,
        onQueryChange = {
            query.value = it
            isActive.value = query.value.trim().isNotEmpty()
        },
        onSearch = {},
        active = isActive.value,
        onActiveChange = {},
        leadingIcon = {
            Image(
                painterResource(R.drawable.views),
                contentDescription = stringResource(id = R.string.views_cd),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable {
                        Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
                    }
            )
        },
        trailingIcon = {
            Image(
                painterResource(R.drawable.views),
                contentDescription = stringResource(id = R.string.views_cd),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable {
                        Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
                    }
            )
        }
    ) {
    }

}


