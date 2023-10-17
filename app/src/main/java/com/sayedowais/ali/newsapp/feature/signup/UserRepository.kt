package com.sayedowais.ali.newsapp.feature.signup

import android.util.Log
import com.sayedowais.ali.newsapp.feature.signup.network.CategoriesResponse
import com.sayedowais.ali.newsapp.feature.signup.network.CountriesResponse
import com.sayedowais.ali.newsapp.feature.signup.network.SignupResponse
import com.sayedowais.ali.newsapp.feature.signup.network.UserRequest
import com.sayedowais.ali.newsapp.network.ApiResult
import com.sayedowais.ali.newsapp.network.getResult
import com.sayedowais.ali.newsapp.network.service.NewsApiService
import retrofit2.http.Path
import javax.inject.Inject

class UserRepository @Inject constructor(private val newsApiService: NewsApiService) {
    suspend fun createUser(
        email: String,
        country: String,
        category: String
    ) : ApiResult<SignupResponse> {
        val result = getResult{ newsApiService.createUser(userRequest = UserRequest(email, country, category))}
        return result
    }

    suspend fun logInUser(
        email: String
    ) : ApiResult<SignupResponse> {
        val result = getResult{ newsApiService.loginUser(email = email)}
        return result
    }

    suspend fun getCountries() : ApiResult<CountriesResponse> {
        val result = getResult{ newsApiService.getCountries() }
        return result
    }

    suspend fun getCategories() : ApiResult<CategoriesResponse> {
        val result = getResult{ newsApiService.getCategories() }
        return result
    }
}