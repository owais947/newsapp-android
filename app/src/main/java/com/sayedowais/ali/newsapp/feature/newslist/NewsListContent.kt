package com.sayedowais.ali.newsapp.feature.newslist

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sayedowais.ali.newsapp.R
import com.sayedowais.ali.newsapp.common.DropDownField
import com.sayedowais.ali.newsapp.common.GreetingText
import com.sayedowais.ali.newsapp.common.NewsAppImage
import com.sayedowais.ali.newsapp.common.SubmitButton
import com.sayedowais.ali.newsapp.common.TextInputField
import com.sayedowais.ali.newsapp.feature.destinations.NewsPageScreenDestination
import com.sayedowais.ali.newsapp.feature.newslist.model.view.NewsEntity

@Composable
fun NewsListContent(modifier: Modifier, newsList: List<NewsEntity>, navigator: DestinationsNavigator) {
    LazyColumn(modifier = modifier
        .fillMaxSize()) {
        items(newsList.size) { index ->
            NewsEntry(news = newsList[index], navigator = navigator)
        }
    }
}
@Composable
fun NewsEntry(news: NewsEntity, navigator: DestinationsNavigator) {
//    val constraints = ConstraintSet {
//        val newsImage = createRefFor("newsImage")
//        val newsTitle = createRefFor("newsTitle")
//        val newsPublishedAt = createRefFor("newsPublishedAt")
//
//        constrain(newsImage) {
//            top.linkTo(parent.top)
//            start.linkTo(parent.start)
//            bottom.linkTo(parent.bottom)
//        }
//        constrain(newsTitle) {
//            start.linkTo(newsImage.end)
//            top.linkTo(newsImage.top)
//            end.linkTo(parent.end, margin = 8.dp)
//        }
//        constrain(newsPublishedAt) {
//            bottom.linkTo(newsImage.bottom)
//            start.linkTo(newsImage.end, margin = 8.dp)
//            top.linkTo(newsTitle.bottom)
//        }
//    }
//
//    ConstraintLayout(
//        constraints,
//        modifier = Modifier
//            .padding(8.dp)
//            .clickable {
//                navigator.navigate(NewsPageScreenDestination(news))
//            }
//    ) {
//        NewsAppImage(
//            modifier = Modifier
//                .layoutId("newsImage")
//                .height(96.dp)
//                .width(96.dp),
//            imageUrl = news.urlToImage
//        )
//        Text(
//            text = news.title,
//            modifier = Modifier
//                .layoutId("newsTitle")
//                .clipToBounds()
//                .padding(8.dp),
//            fontWeight = FontWeight.Bold,
//            color = Color(0xFF000000)
//        )
//        Text(
//            text = news.formattedPublishedAt,
//            modifier = Modifier.layoutId("newsPublishedAt"),
//            fontWeight = FontWeight.Light,
//            color = Color(0xFF000000)
//        )
//    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(all = 16.dp)
            .clickable {
                navigator.navigate(NewsPageScreenDestination(news))
            }, shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Row {
            Box(modifier = Modifier.padding(all = 4.dp))
            {
                NewsAppImage(
                    modifier = Modifier
                        .width(96.dp)
                        .height(96.dp), imageUrl = news.urlToImage
                )
            }

            Column(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    text = news.title,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                    letterSpacing = 0.12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier,
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Text(
                        text = news.source, fontSize = 13.sp,
                        lineHeight = 19.5.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF4E4B66),
                        letterSpacing = 0.12.sp,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "TimeIcon",
                        contentScale = ContentScale.None,
                        modifier =
                        Modifier
                            .padding(1.dp)
                            .width(14.dp)
                            .height(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = news.formattedPublishedAt, fontSize = 13.sp,
                        lineHeight = 19.5.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF4E4B66),
                        letterSpacing = 0.12.sp,
                    )
                }
            }
        }
    }
}