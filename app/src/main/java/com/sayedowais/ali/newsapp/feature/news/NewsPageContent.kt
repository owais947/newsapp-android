package com.sayedowais.ali.newsapp.feature.news

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.layoutId
import com.sayedowais.ali.newsapp.R
import com.sayedowais.ali.newsapp.common.NewsAppImage
import com.sayedowais.ali.newsapp.feature.newslist.model.network.Article
import com.sayedowais.ali.newsapp.feature.newslist.model.network.NewsResponse
import com.sayedowais.ali.newsapp.feature.newslist.model.view.NewsEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsPageContent(article: NewsEntity) {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = android.net.Uri.parse(article.url)
                    }
                          context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(Color(0xFF1877F2))
            ) {
                Text(
                    text = "Read Full Article",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        letterSpacing = 0.12.sp
                    )
                )
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .layoutId("sourceRow")
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Source Image",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .layoutId("sourceImage")
                            .padding(16.dp)
                            .size(50.dp, 50.dp)
                    )
                    Column {
                        Text(
                            text = article.source?: "Source",
                            modifier = Modifier
                                .layoutId("source")
                                .padding(0.dp, 16.dp, 0.dp, 0.dp)
                                .fillMaxWidth(),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                                letterSpacing = 0.12.sp
                            )
                        )
                        Text(
                            text = article.author?: "Author",
                            modifier = Modifier
                                .layoutId("category")
                                .padding(0.dp, 8.dp, 0.dp, 0.dp)
                                .fillMaxWidth(),
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                                letterSpacing = 0.12.sp
                            )
                        )
                    }
                }
                NewsAppImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .layoutId("image"),
                    imageUrl = article.urlToImage?: "",
                )
                Text(
                    text = article.title?: "Title",
                    modifier = Modifier
                        .padding(16.dp)
                        .layoutId("title")
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 36.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        letterSpacing = 0.12.sp
                    )
                )
                Text(
                    text = article.formattedPublishedAt?: "Published At",
                    modifier = Modifier
                        .padding(16.dp)
                        .layoutId("publishedAt")
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        letterSpacing = 0.12.sp
                    )
                )
                Text(
                    text = article.content?: "Content",
                    modifier = Modifier
                        .padding(16.dp)
                        .layoutId("content")
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        letterSpacing = 0.12.sp
                    )
                )
            }
        }
    )
}