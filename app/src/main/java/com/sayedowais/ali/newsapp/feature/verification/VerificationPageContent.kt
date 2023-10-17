package com.sayedowais.ali.newsapp.feature.verification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sayedowais.ali.newsapp.common.GreetingText
import com.sayedowais.ali.newsapp.common.SubmitButton
import com.sayedowais.ali.newsapp.common.TextInputField
import com.sayedowais.ali.newsapp.feature.destinations.LoginScreenDestination

@Composable
fun VerificationPageContent(navigator: DestinationsNavigator) {
    val constraints = ConstraintSet {
        val greetingText = createRefFor("greetingText")
        val loginButton = createRefFor("loginButton")

        constrain(greetingText) {
            top.linkTo(parent.top, margin = 40.dp)
            start.linkTo(parent.start)
        }

        constrain(loginButton) {
            bottom.linkTo(parent.bottom, margin = 40.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
    ConstraintLayout(
        constraints,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
    ) {
        GreetingText(
            title = "",
            body = "Please verify your email address and Login",
            id = "greetingText"
        )
        Button(onClick = {
                         navigator.navigate(LoginScreenDestination)
        },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF1877F2)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .layoutId("loginButton")
                .background(color = Color(0xFF1877F2), shape = RoundedCornerShape(size = 6.dp))) {
            Text(
                text = "Login"
            )
        }
    }
}