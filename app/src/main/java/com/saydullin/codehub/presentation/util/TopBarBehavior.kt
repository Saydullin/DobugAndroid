package com.saydullin.codehub.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource

class TopBarBehavior(
    val state: TopBarScrollState
) {

    val nestedScrollConnection = object : NestedScrollConnection {

        override fun onPostScroll(
            consumed: Offset,
            available: Offset,
            source: NestedScrollSource
        ): Offset {
            state.scrollOffset += consumed.y * -1
            return super.onPostScroll(consumed, available, source)
        }

    }

}

@Composable
fun rememberTopBarScrollBehavior() = TopBarBehavior(
    state = rememberTopBarScrollState(
        initialTotalScrollOffset = 0f
    )
)


