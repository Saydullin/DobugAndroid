package com.saydullin.codehub.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Stable
class TopBarScrollState(
    initialTotalScrollOffset: Float
) {

    companion object {
        val Saver: Saver<TopBarScrollState, *> = listSaver(
            save = { listOf(it.scrollOffset) },
            restore = {
                TopBarScrollState(
                    initialTotalScrollOffset = it[0]
                )
            }
        )
    }

    var scrollOffset by mutableFloatStateOf(initialTotalScrollOffset)
}

@Composable
internal fun rememberTopBarScrollState(
    initialTotalScrollOffset: Float = 0f
) = rememberSaveable(saver = TopBarScrollState.Saver) {
    TopBarScrollState(
        initialTotalScrollOffset = initialTotalScrollOffset
    )
}


