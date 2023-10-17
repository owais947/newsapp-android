package com.sayedowais.ali.newsapp.feature.signup.network

import com.google.gson.annotations.SerializedName

data class CountriesResponse(
    @SerializedName("data")
    val countries: List<String>,
    @SerializedName("success")
    val success: Boolean
)