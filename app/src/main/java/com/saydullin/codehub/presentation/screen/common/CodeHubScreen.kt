package com.saydullin.codehub.presentation.screen.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.saydullin.codehub.presentation.util.rememberTopBarScrollBehavior

@Composable
fun CodeHubScreen(
    modifier: Modifier = Modifier,
    appBarModifier: Modifier = Modifier,
    title: String? = null,
    appBarContent: @Composable () -> Unit = {},
    showOnlyAppBarContent: Boolean = false,
    showBackButton: Boolean = false,
    onBackButtonClick: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    val scrollState = rememberTopBarScrollBehavior()

    Scaffold(
        modifier = modifier
            .nestedScroll(scrollState.nestedScrollConnection),
        topBar = {
            CodeHubTopBar(
                modifier = appBarModifier,
                title = title,
                scrollState = scrollState,
                content = appBarContent,
                showOnlyContent = showOnlyAppBarContent,
                showBackButton = showBackButton,
                onBackButtonClick = onBackButtonClick,
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            content()
        }
    }

}


