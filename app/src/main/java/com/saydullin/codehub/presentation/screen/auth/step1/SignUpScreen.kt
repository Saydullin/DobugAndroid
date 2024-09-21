package com.saydullin.codehub.presentation.screen.auth.step1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.component.button.HintButton
import com.saydullin.codehub.presentation.navigation.Screen
import com.saydullin.codehub.presentation.screen.auth.component.SignInForm
import com.saydullin.codehub.presentation.viewModel.AuthViewModel

@Composable
fun SignUpScreen(
    navController: NavController = rememberNavController(),
    authViewModel: AuthViewModel = hiltViewModel(),
) {

    val status = authViewModel.status.value

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
                        HintButton(
                            onClick = { /*TODO*/ },
                            text = "Log in",
                            textStyle = MaterialTheme.typography.titleMedium
                        )
                    }
                },
                onSubmit = {
                    authViewModel.signIn(it)
                    navController.navigate(Screen.SignedInScreen.route)
                }
            )
        }
    }

}