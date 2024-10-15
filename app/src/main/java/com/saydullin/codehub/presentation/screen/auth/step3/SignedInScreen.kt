package com.saydullin.codehub.presentation.screen.auth.step3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen
import com.saydullin.domain.model.user.User

@Composable
fun SignedInScreen(
    navController: NavController = rememberNavController()
) {

    val user = User("Сай", "saydullindev@gmail.com", "543i489dw3f33d2")

    CodeHubScreen(
        title = user.username,
        appBarModifier = Modifier
            .padding(16.dp),
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Аккаунт успешно создан!",
                        style = MaterialTheme.typography.displayLarge
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Никакой рекламы, неограниченное количество публикаций и запросов ИИ-ботам!",
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            }
        }
    }

}