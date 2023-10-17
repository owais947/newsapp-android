package com.sayedowais.ali.newsapp.feature.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sayedowais.ali.newsapp.MainActivity
import com.sayedowais.ali.newsapp.feature.verification.VerificationViewModel


@Composable
@Destination
fun LoginScreen(
    mainActivity: MainActivity,
    navigator: DestinationsNavigator,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
   LoginPageContent(navigator = navigator)
}