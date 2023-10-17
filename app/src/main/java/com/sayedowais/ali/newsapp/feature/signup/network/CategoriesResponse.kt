package com.sayedowais.ali.newsapp.feature.signup.network

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("data")
    val categories: List<String>,
    @SerializedName("success")
    val success: Boolean
)