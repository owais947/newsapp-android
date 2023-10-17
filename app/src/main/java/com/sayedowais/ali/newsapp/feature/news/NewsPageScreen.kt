package com.sayedowais.ali.newsapp.feature.news

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sayedowais.ali.newsapp.MainActivity
import com.sayedowais.ali.newsapp.feature.login.LoginViewModel
import com.sayedowais.ali.newsapp.feature.newslist.model.view.NewsEntity

@Destination
@Composable
fun NewsPageScreen(
    mainActivity: MainActivity,
    navigator: DestinationsNavigator,
    loginViewModel: LoginViewModel = hiltViewModel(),
    news: NewsEntity
) {
    NewsPageContent(article = news)
}