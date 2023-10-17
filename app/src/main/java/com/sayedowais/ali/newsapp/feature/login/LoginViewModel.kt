package com.sayedowais.ali.newsapp.feature.login

import androidx.lifecycle.ViewModel
import com.sayedowais.ali.newsapp.feature.newslist.model.view.NewsUIState
import com.sayedowais.ali.newsapp.feature.signup.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<NewsUIState>(value = NewsUIState.Loading)
    val uiState = _uiState.asStateFlow()
}