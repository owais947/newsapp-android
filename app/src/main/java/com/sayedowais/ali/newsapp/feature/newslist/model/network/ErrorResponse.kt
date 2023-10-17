package com.sayedowais.ali.newsapp.feature.newslist.model.network

import com.google.gson.annotations.SerializedName

data class ErrorResponse (
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: String? = null
    )