package com.saydullin.codehub.presentation.screen.auth.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saydullin.codehub.presentation.component.editor.input.password.PasswordInputEditor
import com.saydullin.codehub.presentation.component.editor.input.primary.InputEditor
import com.saydullin.domain.model.user.User

@Composable
fun SignInForm(
    modifier: Modifier = Modifier,
    onSubmit: (User) -> Unit,
) {

    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = modifier
                .width(250.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                text = "Sign in",
                style = MaterialTheme.typography.headlineSmall
            )

            InputEditor(
                onInputEdit = { username.value = it },
                placeholder = "Create your own username",
                label = "Username"
            )
            InputEditor(
                onInputEdit = { email.value = it },
                placeholder = "Login",
                label = "Email"
            )
            PasswordInputEditor(
                onInputEdit = { password.value = it },
                placeholder = "[0-9][Aa-Zz][@#$%^&+=]",
                label = "Password"
            )
            Button(
                modifier = Modifier
                    .padding(top = 16.dp),
                onClick = {
                    val user = User(
                        username = username.value,
                        email = email.value,
                        password = password.value
                    )

                    onSubmit(user)
                }
            ) {
                Text(
                    text = "Create account",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }

}