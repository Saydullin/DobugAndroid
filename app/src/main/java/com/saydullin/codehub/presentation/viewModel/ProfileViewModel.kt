package com.saydullin.codehub.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.domain.model.profile.Profile
import com.saydullin.domain.usecase.GetProfileUseCase
import com.saydullin.domain.util.response.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase
): ViewModel() {

    private val _profileData = mutableStateOf<Profile?>(null)
    private val _error = mutableStateOf<String?>(null)
    val profileData = _profileData
    val error = _error

    fun getProfileData() {
        viewModelScope.launch(Dispatchers.IO) {
            val profileRes = getProfileUseCase.execute()
            if (profileRes is Resource.Success && profileRes.data != null) {
                _profileData.value = profileRes.data
            } else {
                _error.value = "Ops"
            }
        }
    }

}