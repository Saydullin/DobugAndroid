package com.saydullin.codehub.presentation.screen.auth.step2

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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

@Composable
fun SignUpScreen(
    navController: NavController = rememberNavController(),
    authViewModel: AuthViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    val status = authViewModel.status.value

    if (status?.status != null) {
        Toast.makeText(context, "status ${status.status}, message ${status.message}", Toast.LENGTH_SHORT).show()
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
                    authViewModel.signUp(it)
                    navController.navigate(Screen.SignedInScreen.route)
                }
            )
        }
    }

}