package com.saydullin.codehub.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.codehub.di.mapper.PostUItoPostMapper
import com.saydullin.codehub.presentation.model.post.PostUI
import com.saydullin.domain.model.post.Post
import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.response.Paging
import com.saydullin.domain.usecase.post.GetPostsUseCase
import com.saydullin.domain.usecase.post.SavePostUseCase
import com.saydullin.domain.util.response.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val savePostUseCase: SavePostUseCase,
    private val postUItoPostMapper: PostUItoPostMapper,
): ViewModel() {

    private val _posts = mutableStateOf<MainResponse<Paging<Post>>?>(null)
    val posts = _posts
    private val _status = mutableStateOf<String?>(null)
    val status = _status
    private val _error = mutableStateOf<String?>(null)
    val error = _error

    fun getAllPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            val postsResource = getPostsUseCase.execute()

            when(postsResource) {
                is Resource.Success -> {
                    _posts.value = postsResource.data
                }
                is Resource.Error -> {
                    _error.value = postsResource.status.toString()
                }
            }
        }
    }

    fun savePost(postUI: PostUI) {
        viewModelScope.launch(Dispatchers.IO) {
            val post = postUItoPostMapper.map(postUI)
            val postsResource = savePostUseCase.execute(post)

            if (postsResource.isErrorData()) {
                _error.value = postsResource.status.toString()
            } else {
                _status.value = "Ok"
            }
        }
    }

}