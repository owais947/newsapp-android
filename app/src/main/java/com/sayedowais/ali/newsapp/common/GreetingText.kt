package com.sayedowais.ali.newsapp.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.layoutId
import org.w3c.dom.Text
import java.lang.ref.Reference

@Composable
fun GreetingText(title: String, body: String, id: String) {
    Column(
        modifier = Modifier.layoutId(id)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth(),
            color = (Color(0xFF1877F2)),
            fontSize = 48.sp,
            fontWeight = FontWeight(700)
        )
        Text(
            text = body,
            modifier = Modifier
                .fillMaxWidth(),
            color = (Color(0xFF4E4B66)),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
    }
}