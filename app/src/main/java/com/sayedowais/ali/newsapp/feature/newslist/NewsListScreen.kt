package com.sayedowais.ali.newsapp.feature.newslist

import android.os.Parcelable
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sayedowais.ali.newsapp.MainActivity
import com.sayedowais.ali.newsapp.R
import com.sayedowais.ali.newsapp.common.EmptyScreen
import com.sayedowais.ali.newsapp.common.ErrorScreen
import com.sayedowais.ali.newsapp.common.LoadingScreen
import com.sayedowais.ali.newsapp.common.NewsAppHeader
import com.sayedowais.ali.newsapp.feature.newslist.model.view.NewsUIState
import kotlinx.parcelize.Parcelize

//
//@Parcelize
//data class SampleData(
//    val sourceScreen : String
//) : Parcelable

@Destination
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListScreen(
    mainActivity: MainActivity,
    newsListViewModel: NewsListViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
    email: String
) {
    Log.d("NewsListScreen", "email: $email")
    LaunchedEffect(Unit) {
        newsListViewModel.fetchPopularNews(email = email)
    }
    val uiState by newsListViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Text(
                //text = stringResource(id = R.string.app_name),
                text = "Latest News",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                when (uiState) {
                    NewsUIState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
                    is NewsUIState.CustomError -> EmptyScreen(
                        modifier = Modifier.fillMaxSize(),
                        text = (uiState as NewsUIState.CustomError).error.message ?: "Something went wrong"
                    )
                    is NewsUIState.Error -> EmptyScreen(
                        modifier = Modifier.fillMaxSize(),
                        text = "No news for you at the moment :P"
                    )

                    is NewsUIState.NewsListSuccess -> NewsListContent(
                        modifier = Modifier.fillMaxSize(),
                        newsList = (uiState as NewsUIState.NewsListSuccess).newsList,
                        navigator = navigator
                    )

                    else -> {}
                }
            }
        }
    )
}