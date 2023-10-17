package com.sayedowais.ali.newsapp.feature.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sayedowais.ali.newsapp.common.DropDownField
import com.sayedowais.ali.newsapp.common.GreetingText
import com.sayedowais.ali.newsapp.common.SubmitButton
import com.sayedowais.ali.newsapp.common.TextInputField
import com.sayedowais.ali.newsapp.feature.destinations.NewsListScreenDestination

@Composable
fun LoginPageContent(navigator: DestinationsNavigator) {
    val constraints = ConstraintSet {
        val greetingText = createRefFor("greetingText")
        val emailField = createRefFor("emailField")
        val loginButton = createRefFor("loginButton")

        constrain(greetingText) {
            top.linkTo(parent.top, margin = 40.dp)
            start.linkTo(parent.start)
        }
        constrain(emailField) {
            top.linkTo(greetingText.bottom, margin = 40.dp)
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
            title = "Hello!",
            body = "Log in to get your news!",
            id = "greetingText"
        )
        val email = TextInputField(title = "Email", id = "emailField")
        Log.d("email", email)
        Button(onClick = {
            Log.d("email", email)
                         navigator.navigate(NewsListScreenDestination(email))
            Log.d("email-after", email)
        },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF1877F2)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .layoutId("loginButton")
                .background(color = Color(0xFF1877F2), shape = RoundedCornerShape(size = 6.dp))) {
            Text(
                text = "Log in"
            )
        }
    }
}