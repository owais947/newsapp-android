package com.sayedowais.ali.newsapp.feature.newslist.model.network

import com.google.gson.annotations.SerializedName
import java.util.Date

data class NewsResponse(
    @SerializedName("data")
    val articles: List<Article>?,

    @SerializedName("success")
    val success: Boolean?
)

data class Article(
    @SerializedName("author")
    val author: String?,

    @SerializedName("content")
    val content: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("publishedAt")
    val publishedAt: Date?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("urlToImage")
    val urlToImage: String?,

    @SerializedName("source")
    val source: String?
)