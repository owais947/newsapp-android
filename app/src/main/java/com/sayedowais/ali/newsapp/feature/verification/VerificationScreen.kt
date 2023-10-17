package com.sayedowais.ali.newsapp.feature.verification

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sayedowais.ali.newsapp.MainActivity
import com.sayedowais.ali.newsapp.common.EmptyScreen
import com.sayedowais.ali.newsapp.common.ErrorScreen
import com.sayedowais.ali.newsapp.common.LoadingScreen
import com.sayedowais.ali.newsapp.feature.destinations.NewsListScreenDestination
import com.sayedowais.ali.newsapp.feature.newslist.model.view.NewsUIState
import com.sayedowais.ali.newsapp.feature.signup.SignupViewModel

@Destination
@Composable
fun VerificationScreen(
    mainActivity: MainActivity,
    navigator: DestinationsNavigator,
    verificationViewModel: VerificationViewModel = hiltViewModel(),
    email : String,
    country: String,
    category: String
) {
    LaunchedEffect(Unit){
        verificationViewModel.createNewUser(email = email, country = country, category = category)
    }
    val uiState by verificationViewModel.uiState.collectAsStateWithLifecycle()

    when(uiState){
        NewsUIState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        is NewsUIState.CustomError -> ErrorScreen(modifier = Modifier.fillMaxSize(), error = (uiState as NewsUIState.CustomError).error)
        is NewsUIState.SignupSuccess -> VerificationPageContent(navigator = navigator)
        else -> { }
    }
}
