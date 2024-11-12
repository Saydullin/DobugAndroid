package com.saydullin.codehub.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.user.User
import com.saydullin.domain.model.user.UserAuthenticated
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

    private val _status = mutableStateOf<Resource<MainResponse<UserAuthenticated>>?>(null)
    val status = _status

    private val _loading = mutableStateOf(false)
    val loading = _loading

    fun signUpServer(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true

            val createdUserResource = createAccountUseCase.execute(user)

            _status.value = createdUserResource
            _loading.value = false
        }
    }

    fun signUpLocal(user: User) {

    }

    fun signIn(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true

            val createResource = createAccountUseCase.execute(user)

            _status.value = createResource
            _loading.value = false
        }
    }

    fun reset() {
        status.value = null
        loading.value = false
    }

}