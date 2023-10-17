package com.sayedowais.ali.newsapp.feature.newslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.sayedowais.ali.newsapp.feature.newslist.model.network.ErrorResponse
import com.sayedowais.ali.newsapp.feature.newslist.model.view.NewsUIState
import com.sayedowais.ali.newsapp.feature.signup.UserRepository
import com.sayedowais.ali.newsapp.network.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(private val newsRepository : NewsListRepository, private val userRepository: UserRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow<NewsUIState>(value = NewsUIState.Loading)
    val uiState = _uiState.asStateFlow()

    fun fetchPopularNews(email: String) {
        viewModelScope.launch(Dispatchers.IO){
            when(val result = userRepository.logInUser(email)) {
                is ApiResult.Success -> {
                    val userId = result.data.id
                    when(val newsResult = newsRepository.fetchNews(userId)) {
                        is ApiResult.Success -> {

                            val newsItemResponse = newsResult.data.articles ?: listOf()

                            if(newsItemResponse.isEmpty()) {
                                _uiState.value = NewsUIState.Empty
                            }
                            else {
                                val mapper = NewsListMapper()
                                _uiState.value = NewsUIState.NewsListSuccess(mapper.map(newsItemResponse))
                            }
                        }
                        is ApiResult.Error -> {
                            _uiState.value = NewsUIState.Error(newsResult.message)
                        }
                    }
                }
                is ApiResult.Error -> {
                    _uiState.value = NewsUIState.CustomError(Gson().fromJson(result.message, ErrorResponse::class.java))
                }
            }
        }
    }
}