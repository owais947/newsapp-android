package com.sayedowais.ali.newsapp.feature.newslist.model.view

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsEntity (
    val author : String,
    val content : String,
    val description : String,
    val formattedPublishedAt : String,
    val title : String,
    val url : String,
    val urlToImage : String,
    val source : String
) : Parcelable