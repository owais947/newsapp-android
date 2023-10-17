package com.sayedowais.ali.newsapp.feature.signup

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontSynthesis.Companion.Style
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sayedowais.ali.newsapp.MainActivity
import com.sayedowais.ali.newsapp.common.DropDownField
import com.sayedowais.ali.newsapp.common.GreetingText
import com.sayedowais.ali.newsapp.common.SubmitButton
import com.sayedowais.ali.newsapp.common.TextInputField
import com.sayedowais.ali.newsapp.feature.destinations.LoginScreenDestination
import com.sayedowais.ali.newsapp.feature.destinations.VerificationScreenDestination
import com.sayedowais.ali.newsapp.feature.verification.VerificationScreen
import com.sayedowais.ali.newsapp.feature.verification.VerificationViewModel

@Composable
fun SignupPageContent(countries: List<String>, categories: List<String>, navigator: DestinationsNavigator) {
    val constraints = ConstraintSet {
        val greetingText = createRefFor("greetingText")
        val emailField = createRefFor("emailField")
        val countryField = createRefFor("countryField")
        val categoryField = createRefFor("categoryField")
        val signUpButton = createRefFor("signUpButton")
        val loginText = createRefFor("loginText")

        constrain(greetingText) {
            top.linkTo(parent.top, margin = 40.dp)
            start.linkTo(parent.start)
        }
        constrain(emailField) {
            top.linkTo(greetingText.bottom, margin = 40.dp)
            start.linkTo(parent.start)
        }
        constrain(countryField) {
            top.linkTo(emailField.bottom, margin = 40.dp)
            start.linkTo(parent.start)
        }
        constrain(categoryField) {
            top.linkTo(countryField.bottom, margin = 40.dp)
            start.linkTo(parent.start)
        }
        constrain(signUpButton) {
            bottom.linkTo(parent.bottom, margin = 40.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(loginText) {
            top.linkTo(signUpButton.bottom, margin = 20.dp)
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
            body = "Sign up to get started",
            id = "greetingText"
        )
        var email = TextInputField(title = "Email", id = "emailField")
        var country = DropDownField(title = "Country", id = "countryField", countries)
        var category = DropDownField(title = "Category", id = "categoryField", categories)
        Button(onClick = {
                         navigator.navigate(VerificationScreenDestination(email, country, category))
        },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF1877F2)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .layoutId("signUpButton")
                .background(color = Color(0xFF1877F2), shape = RoundedCornerShape(size = 6.dp))) {
            Text(
                text = "Sign up"
            )
        }

        Text(
            text = "Already have an account? Log in",
            modifier = Modifier
                .layoutId("loginText")
                .clickable {
                    navigator.navigate(LoginScreenDestination)
                },
            color = Color(0xFF1877F2)
        )
    }
}