package com.saydullin.codehub.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.domain.model.tag.Tag
import com.saydullin.domain.usecase.tag.remote.GetAllServerTagsUseCase
import com.saydullin.domain.util.response.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TagViewModel @Inject constructor(
    private val getAllServerTagsUseCase: GetAllServerTagsUseCase
): ViewModel() {

    private val _error = mutableStateOf<Resource.Error<Unit>?>(null)
    val error: State<Resource.Error<Unit>?> = _error

    private val _tags = mutableStateOf<List<Tag>?>(null)
    val tags: State<List<Tag>?> = _tags

    fun getAllServerTags() {
        viewModelScope.launch(Dispatchers.Default) {
            val serverTagsResource = getAllServerTagsUseCase.execute()
            val serverTags = serverTagsResource.data

            if (serverTagsResource.isErrorData() || serverTags == null) {
                _error.value = serverTagsResource.getError()

                return@launch
            }

            _tags.value = serverTags
        }
    }

}