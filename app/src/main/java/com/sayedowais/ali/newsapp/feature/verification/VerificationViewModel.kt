package com.sayedowais.ali.newsapp.feature.verification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.sayedowais.ali.newsapp.feature.newslist.NewsListRepository
import com.sayedowais.ali.newsapp.feature.newslist.model.network.ErrorResponse
import com.sayedowais.ali.newsapp.feature.newslist.model.view.NewsUIState
import com.sayedowais.ali.newsapp.feature.signup.UserRepository
import com.sayedowais.ali.newsapp.feature.signup.network.UserRequest
import com.sayedowais.ali.newsapp.network.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerificationViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<NewsUIState>(value = NewsUIState.Loading)
    val uiState = _uiState.asStateFlow()

    fun createNewUser(email: String, country: String, category: String){
        viewModelScope.launch(Dispatchers.IO) {
            when (val result =
                repository.createUser(email = email, country = country, category = category)) {
                is ApiResult.Success -> {
                    val userResponse = result.data
                    _uiState.value = NewsUIState.SignupSuccess(userResponse.id.toString())
                }

                is ApiResult.Error -> {
                    _uiState.value = NewsUIState.CustomError(Gson().fromJson(result.message, ErrorResponse::class.java))
                }
            }
        }
    }
}
