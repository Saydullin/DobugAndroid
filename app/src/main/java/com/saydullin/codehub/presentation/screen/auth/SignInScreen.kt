package com.saydullin.codehub.presentation.screen.auth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.screen.auth.component.SignInForm
import com.saydullin.codehub.presentation.viewModel.AuthViewModel

@Composable
fun SignInScreen(
    navController: NavController = rememberNavController(),
    authViewModel: AuthViewModel = hiltViewModel(),
) {

    val status = authViewModel.status.value

    LazyColumn {
        item {
            SignInForm(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                onSubmit = { authViewModel.signIn(it) }
            )
        }
    }

}