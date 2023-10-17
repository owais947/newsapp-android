package com.sayedowais.ali.newsapp.feature.signup.network

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class SignupResponse (
    @SerializedName("id")
    val id: UUID,
    @SerializedName("success")
    val success: Boolean
)