package com.sayedowais.ali.newsapp.common

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.layoutId

@Composable
fun SubmitButton(title: String, id: String) {
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
           Color(0xFF1877F2)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .layoutId(id)
            .background(color = Color(0xFF1877F2), shape = RoundedCornerShape(size = 6.dp))) {
        Text(
            text = title
        )
    }
}