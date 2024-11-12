package com.saydullin.codehub.presentation.screen.auth.step1

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.component.button.PrimaryButton
import com.saydullin.codehub.presentation.navigation.Screen
import com.saydullin.codehub.presentation.screen.auth.component.SignInForm
import com.saydullin.codehub.presentation.viewModel.AuthViewModel
import com.saydullin.domain.util.response.Resource

@Composable
fun SignUpScreen(
    navController: NavController = rememberNavController(),
    authViewModel: AuthViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    val status = authViewModel.status.value
    val loading = authViewModel.loading.value

    if (status is Resource.Success) {
        if (status.data?.isSuccess == true) {
            navController.navigate(Screen.SignedInScreen.route)
        } else {
            Toast.makeText(context, status.message, Toast.LENGTH_SHORT).show()
        }

        authViewModel.reset()
    } else if (status?.message != null) {
        Toast.makeText(context, status.message, Toast.LENGTH_SHORT).show()
    }

    if (loading) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        return
    }

    LazyColumn {
        item {
            SignInForm(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                header = {
                    Row(
                        modifier = Modifier
                            .padding(vertical = 32.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "Sign up",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Text(
                            text = "or",
                            color = MaterialTheme.colorScheme.secondary,
                            style = MaterialTheme.typography.headlineSmall
                        )
                        PrimaryButton(
                            onClick = {  },
                            text = "Log in",
                            textStyle = MaterialTheme.typography.titleLarge
                        )
                    }
                },
                onSubmit = {
                    authViewModel.signUpServer(it)
                }
            )
        }
    }

}