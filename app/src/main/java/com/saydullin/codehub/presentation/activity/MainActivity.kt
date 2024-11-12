package com.saydullin.codehub.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.saydullin.codehub.presentation.navigation.NavController
import com.saydullin.codehub.presentation.theme.ui.CodeHubTheme
import com.saydullin.codehub.presentation.viewModel.TagViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val tagViewModel: TagViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tagViewModel.getAllServerTags()

        setContent {
            CodeHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavController(
                        tagViewModel = tagViewModel
                    )
                }
            }
        }
    }
}


