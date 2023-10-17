package com.sayedowais.ali.newsapp.feature.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sayedowais.ali.newsapp.MainActivity
import com.sayedowais.ali.newsapp.common.EmptyScreen
import com.sayedowais.ali.newsapp.common.ErrorScreen
import com.sayedowais.ali.newsapp.common.LoadingScreen
import com.sayedowais.ali.newsapp.feature.destinations.NewsListScreenDestination
import com.sayedowais.ali.newsapp.feature.newslist.NewsListViewModel
import com.sayedowais.ali.newsapp.feature.newslist.model.view.NewsUIState


@Destination(start = true)
@Composable
fun SignupScreen(mainActivity: MainActivity, navigator: DestinationsNavigator, signupViewModel: SignupViewModel = hiltViewModel()) {
    val uiState by signupViewModel.uiState.collectAsStateWithLifecycle()

    when(uiState){
        NewsUIState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        NewsUIState.Empty -> EmptyScreen(modifier = Modifier.fillMaxSize(), text = "No country and category data found")
        is NewsUIState.CustomError -> ErrorScreen(modifier = Modifier.fillMaxSize(), error = (uiState as NewsUIState.CustomError).error)
        is NewsUIState.CategoriesError -> ErrorScreen(modifier = Modifier.fillMaxSize(), error = (uiState as NewsUIState.CategoriesError).error)
        is NewsUIState.CountriesAndCategoriesSuccess -> {
            val countries = (uiState as NewsUIState.CountriesAndCategoriesSuccess).countries
            val categories = (uiState as NewsUIState.CountriesAndCategoriesSuccess).categories
            SignupPageContent(countries = countries, categories = categories, navigator = navigator)
        }
        else -> { }
    }
}