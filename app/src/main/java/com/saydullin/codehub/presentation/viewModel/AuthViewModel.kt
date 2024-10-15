package com.saydullin.codehub.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.domain.model.user.User
import com.saydullin.domain.usecase.auth.CreateAccountUseCase
import com.saydullin.domain.util.response.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val createAccountUseCase: CreateAccountUseCase
): ViewModel() {

    private val _status = mutableStateOf<Resource<Unit>?>(null)
    val status = _status

    fun signUp(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            val createResource = createAccountUseCase.execute(user)

            _status.value = createResource
        }
    }

    fun signIn(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            val createResource = createAccountUseCase.execute(user)

            _status.value = createResource
        }
    }

}