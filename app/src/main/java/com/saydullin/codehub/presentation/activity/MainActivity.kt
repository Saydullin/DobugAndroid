package com.saydullin.codehub.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.saydullin.codehub.domain.model.article.Article
import com.saydullin.codehub.domain.model.article.ArticleAuthor
import com.saydullin.codehub.presentation.navigation.NavController
import com.saydullin.codehub.presentation.theme.ui.CodeHubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val articles = ArrayList<Article>()
        for (i in 1..100) {
            articles.add(
                Article(
                    id = i,
                    imageUrl = "https://randompicturegenerator.com/img/people-generator/g917aa4b51bce7abf6b715d9755db732cbcf18c8d371adc10794d3f8c2017c67fa61633f7d036e9c55f4e5d1be17d4ab5_640.jpg",
                    author = ArticleAuthor(
                        id = 0,
                        firstName = "Samuel",
                        middleName = "Frederick",
                        lastName = "Smith",
                        userName = "SamuelSmith",
                        nickName = "Google News",
                        profileImageUrl = "https://thispersondoesnotexist.com",
                        registrationDate = 1706096686042,
                    ),
                    title = "Three Black Woman",
                    description = "In this article, \"The Benefits of Regular Exercise,\" John Smith explores the numerous advantages of incorporating exercise into our daily routines.",
                    content = "No content",
                    views = 546,
                    likes = 68,
                    publishDate = 1706096686042,
                    updatedDate = 1706096692916,
                    tags = listOf(1, 2, 3, 4),
                    comments = listOf(1, 2, 3, 4),
                    link = "link/1",
                    relatedArticles = listOf(1, 2, 3, 4),
                    isPublished = true,
                    averageRating = 5f,
                )
            )
        }

        setContent {
            CodeHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavController()
                }
            }
        }
    }
}


