package com.sayedowais.ali.newsapp.feature.signup.network

data class UserRequest(
    val email: String,
    val country: String,
    val category: String
)