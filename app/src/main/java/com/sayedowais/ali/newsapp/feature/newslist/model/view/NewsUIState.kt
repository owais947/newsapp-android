package com.sayedowais.ali.newsapp.feature.newslist.model.view

import com.sayedowais.ali.newsapp.feature.newslist.model.network.ErrorResponse

sealed class NewsUIState {
    object Loading : NewsUIState()
    object Empty : NewsUIState()
    data class Error(val message: String) : NewsUIState()
    data class CustomError(val error: ErrorResponse) : NewsUIState()
    data class NewsListSuccess(val newsList: List<NewsEntity>) : NewsUIState()
    //data class NewsListError(val message: String) : NewsUIState()

    data class SignupSuccess(val userId: String) : NewsUIState()
    //data class SignupError(val message: String) : NewsUIState()

    data class CountriesAndCategoriesSuccess(val countries: List<String>, val categories: List<String>) : NewsUIState()
    //data class CountriesError(val message: String) : NewsUIState()
    data class CategoriesError(val error: ErrorResponse) : NewsUIState()
}