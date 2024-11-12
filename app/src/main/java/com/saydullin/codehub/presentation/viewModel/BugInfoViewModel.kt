package com.saydullin.codehub.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.domain.model.post.Post
import com.saydullin.domain.usecase.post.server.GetServerPostInfoUseCase
import com.saydullin.domain.util.response.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BugInfoViewModel @Inject constructor(
    private val getServerPostInfoUseCase: GetServerPostInfoUseCase
): ViewModel() {

    private val _post = mutableStateOf<Post?>(null)
    val post: State<Post?> = _post

    private val _error = mutableStateOf<Resource.Error<Unit>?>(null)
    val error: State<Resource.Error<Unit>?> = _error

    fun getPostById(id: Long) {
        viewModelScope.launch(Dispatchers.Default) {
            val postInfoResource = getServerPostInfoUseCase.execute(id)
            val postInfoResponse = postInfoResource.data
            val postInfoData = postInfoResource.data?.data

            if (postInfoResource.isErrorData() || postInfoResponse == null || postInfoData == null) {
                _error.value = postInfoResource.getError()

                return@launch
            }

            _post.value = postInfoData
        }
    }

}