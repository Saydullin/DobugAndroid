package com.saydullin.codehub.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saydullin.domain.repository.sharedPref.NewPostSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewPostViewModel @Inject constructor(
    private val newPostSharedPreferences: NewPostSharedPreferences
): ViewModel() {

    private val _title = mutableStateOf("")
    val title: State<String> = _title

    private val _description = mutableStateOf("")
    val description: State<String> = _description

    fun exportFieldsContent() {
        viewModelScope.launch(Dispatchers.IO) {
            _title.value = newPostSharedPreferences.getTitle().first()
            _description.value = newPostSharedPreferences.getDescription().first()
        }
    }

    fun setTitle(text: String) {
        _title.value = text

        viewModelScope.launch(Dispatchers.IO) {
            newPostSharedPreferences.saveTitle(text)
        }
    }

    fun setDescription(text: String) {
        _description.value = text

        viewModelScope.launch(Dispatchers.IO) {
            newPostSharedPreferences.saveDescription(text)
        }
    }

}