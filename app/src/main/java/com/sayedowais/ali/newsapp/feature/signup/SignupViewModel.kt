package com.sayedowais.ali.newsapp.feature.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.sayedowais.ali.newsapp.feature.newslist.NewsListMapper
import com.sayedowais.ali.newsapp.feature.newslist.NewsListRepository
import com.sayedowais.ali.newsapp.feature.newslist.model.network.ErrorResponse
import com.sayedowais.ali.newsapp.feature.newslist.model.view.NewsUIState
import com.sayedowais.ali.newsapp.network.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val repository : UserRepository) :
    ViewModel() {
    private val _uiState = MutableStateFlow<NewsUIState>(value = NewsUIState.Loading)
    val uiState = _uiState.asStateFlow()

    init{
        getAllCountriesAndCategories()
    }


    fun getAllCountriesAndCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getCountries()) {
                is ApiResult.Success -> {
                    val countries = result.data.countries
                    when(val categoriesResult = repository.getCategories()) {
                        is ApiResult.Success -> {
                            val categories = categoriesResult.data.categories
                            _uiState.value = NewsUIState.CountriesAndCategoriesSuccess(countries, categories)
                        }
                        is ApiResult.Error -> {
                            _uiState.value = NewsUIState.CustomError(Gson().fromJson(categoriesResult.message, ErrorResponse::class.java))
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