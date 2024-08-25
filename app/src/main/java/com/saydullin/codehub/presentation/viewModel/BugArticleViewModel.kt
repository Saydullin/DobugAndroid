package com.saydullin.codehub.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.domain.model.article.bug.BugArticle
import com.saydullin.domain.usecase.GetBugArticleDBUseCase
import com.saydullin.domain.util.response.Resource
import com.saydullin.domain.util.response.StatusType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BugArticleViewModel @Inject constructor(
    private val getBugArticleDBUseCase: GetBugArticleDBUseCase
): ViewModel() {

    private val _bugArticles = mutableStateOf<List<BugArticle>?>(null)
    private val _error = mutableStateOf<StatusType?>(null)
    val bugArticles = _bugArticles
    val error = _error

    fun loadBugArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            val loadedArticles = getBugArticleDBUseCase.execute()
            if (loadedArticles is Resource.Success && loadedArticles.data != null) {
                _bugArticles.value = loadedArticles.data
            } else {
                _error.value = loadedArticles.status
            }
        }
    }

}


