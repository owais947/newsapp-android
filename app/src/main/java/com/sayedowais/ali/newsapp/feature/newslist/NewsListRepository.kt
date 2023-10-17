package com.sayedowais.ali.newsapp.feature.newslist

import com.sayedowais.ali.newsapp.feature.newslist.model.network.NewsResponse
import com.sayedowais.ali.newsapp.feature.signup.network.CategoriesResponse
import com.sayedowais.ali.newsapp.feature.signup.network.CountriesResponse
import com.sayedowais.ali.newsapp.feature.signup.network.SignupResponse
import com.sayedowais.ali.newsapp.feature.signup.network.UserRequest
import com.sayedowais.ali.newsapp.network.ApiResult
import com.sayedowais.ali.newsapp.network.getResult
import com.sayedowais.ali.newsapp.network.service.NewsApiService
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.UUID
import javax.inject.Inject

class NewsListRepository @Inject constructor(private val newsApiService: NewsApiService) {
    suspend fun fetchNews(
        userId: UUID
    ) : ApiResult<NewsResponse> {
        val newsResponse = getResult { newsApiService.getNews(
            userId
        ) }
        return newsResponse
    }
}