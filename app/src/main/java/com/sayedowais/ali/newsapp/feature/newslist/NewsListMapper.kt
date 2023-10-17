package com.sayedowais.ali.newsapp.feature.newslist

import com.sayedowais.ali.newsapp.feature.newslist.model.network.Article
import com.sayedowais.ali.newsapp.feature.newslist.model.view.NewsEntity
import java.text.SimpleDateFormat
import java.util.Locale

class NewsListMapper {
    private val dateFormatter = SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.ENGLISH)
    fun map(newsItemResponse: List<Article>) : List<NewsEntity> {
        return newsItemResponse.map {
            NewsEntity(
                author = it.author ?: "",
                content = it.content ?: "",
                description = it.description ?: "",
                formattedPublishedAt = it.publishedAt?.let { date ->
                    dateFormatter.format(date)
                } ?: "",
                title = it.title ?: "",
                url = it.url ?: "",
                urlToImage = it.urlToImage ?: "",
                source = it.source?: ""
            )
        }
    }
}