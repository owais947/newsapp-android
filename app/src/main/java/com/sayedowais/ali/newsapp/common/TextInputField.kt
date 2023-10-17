package com.sayedowais.ali.newsapp.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.layoutId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputField(title: String, id: String) : String {
    var text by remember { mutableStateOf("") }
    ConstraintLayout(
        modifier = Modifier.layoutId(id)
    ) {
        val (textInputField) = createRefs()

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .width(380.dp)
                .background(color = (Color(0xFFFFFFFF))),
            label = { Text(text = title) }
        )
    }
    return text
}