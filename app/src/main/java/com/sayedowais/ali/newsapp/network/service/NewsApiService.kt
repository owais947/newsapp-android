package com.sayedowais.ali.newsapp.network.service

import com.sayedowais.ali.newsapp.BuildConfig
import com.sayedowais.ali.newsapp.feature.newslist.model.network.NewsResponse
import com.sayedowais.ali.newsapp.feature.signup.network.CategoriesResponse
import com.sayedowais.ali.newsapp.feature.signup.network.CountriesResponse
import com.sayedowais.ali.newsapp.feature.signup.network.SignupResponse
import com.sayedowais.ali.newsapp.feature.signup.network.UserRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.UUID

interface NewsApiService {

    @GET("/v0/feed/{userId}")
    suspend fun getNews(
        @Path("userId") userId: UUID
    ) : Response<NewsResponse>


    @POST("v0/sign-up")
    suspend fun createUser(
       @Body userRequest: UserRequest
    ) : Response<SignupResponse>

    @GET("v0/login")
    suspend fun loginUser(
        @Query("email") email: String
    ) : Response<SignupResponse>

    @GET("v1/countries")
    suspend fun getCountries() : Response<CountriesResponse>

    @GET("v1/categories")
    suspend fun getCategories() : Response<CategoriesResponse>
}