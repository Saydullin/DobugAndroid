package com.saydullin.codehub.presentation.screen.projects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saydullin.codehub.R
import com.saydullin.codehub.domain.model.article.ArticleAuthor
import com.saydullin.codehub.domain.model.article.ArticleTag
import com.saydullin.codehub.presentation.component.projects.ProjectCard
import com.saydullin.codehub.presentation.model.author.Author
import com.saydullin.codehub.presentation.model.project.Project
import com.saydullin.codehub.presentation.screen.common.CodeHubScreen

@Composable
fun ProjectsScreen(
    navController: NavController = rememberNavController()
) {
    val ctx = LocalContext.current

    val projects = listOf(
        Project(
            id = 1,
            title = "MusicHub",
            description = "A platform for music lovers to discover new artists, listen to music, and connect with fellow music enthusiasts.",
            images = listOf("musichub_image1.jpg", "musichub_image2.jpg"),
            views = 1000,
            author = ArticleAuthor(
                id = 1,
                firstName = "Alex",
                middleName = "",
                lastName = "Johnson",
                userName = "alexjohnson",
                nickName = "alexj",
                profileImageUrl = "alexjohnson_profile.jpg",
                useful = 50,
                answers = 20,
                tags = listOf(ArticleTag(1, "music"), ArticleTag(2, "community")),
                bio = "A passionate musician and music lover sharing insights and recommendations.",
                regDate = 1632873600,
                updatedDate = 1645219200
            ),
            tags = listOf(ArticleTag(1, "music"), ArticleTag(3, "platform"))
        ),
        Project(
            id = 2,
            title = "FitLife",
            description = "A fitness app to track workouts, set goals, and stay motivated on the journey to a healthier lifestyle.",
            images = listOf("fitlife_image1.jpg", "fitlife_image2.jpg"),
            views = 500,
            author = ArticleAuthor(
                id = 2,
                firstName = "Sophie",
                middleName = "A.",
                lastName = "Parker",
                userName = "sophieparker",
                nickName = "sophiep",
                profileImageUrl = "sophieparker_profile.jpg",
                useful = 30,
                answers = 10,
                tags = listOf(ArticleTag(4, "fitness"), ArticleTag(5, "health")),
                bio = "A certified fitness trainer helping individuals achieve their fitness goals.",
                regDate = 1627833600,
                updatedDate = 1641028800
            ),
            tags = listOf(ArticleTag(4, "fitness"), ArticleTag(6, "tracking"))
        ),
        Project(
            id = 3,
            title = "RecipeGenius",
            description = "An AI-powered recipe generator that suggests personalized recipes based on dietary preferences and ingredients on hand.",
            images = listOf("recipegenius_image1.jpg", "recipegenius_image2.jpg"),
            views = 750,
            author = ArticleAuthor(
                id = 3,
                firstName = "Emma",
                middleName = "R.",
                lastName = "Clark",
                userName = "emmaclark",
                nickName = "emmac",
                profileImageUrl = "emmaclark_profile.jpg",
                useful = 25,
                answers = 12,
                tags = listOf(ArticleTag(7, "cooking"), ArticleTag(8, "recipes")),
                bio = "A culinary enthusiast exploring the world of flavors and experimenting with unique recipes.",
                regDate = 1635724800,
                updatedDate = 1643587200
            ),
            tags = listOf(ArticleTag(7, "cooking"), ArticleTag(9, "AI"))
        ),
        Project(
            id = 4,
            title = "ArtGallery",
            description = "An online platform to showcase and sell artworks created by talented artists from around the world.",
            images = listOf("artgallery_image1.jpg", "artgallery_image2.jpg"),
            views = 2000,
            author = ArticleAuthor(
                id = 4,
                firstName = "Michael",
                middleName = "J.",
                lastName = "Robinson",
                userName = "michaelrobinson",
                nickName = "michaelr",
                profileImageUrl = "michaelrobinson_profile.jpg",
                useful = 40,
                answers = 15,
                tags = listOf(ArticleTag(10, "art"), ArticleTag(11, "creativity")),
                bio = "An artist and art enthusiast passionate about promoting talented individuals in the art world.",
                regDate = 1630348800,
                updatedDate = 1642944000
            ),
            tags = listOf(ArticleTag(10, "art"), ArticleTag(12, "online"))
        ),
        Project(
            id = 5,
            title = "Bookworm",
            description = "A book recommendation app that helps users discover new books based on their preferences and reading history.",
            images = listOf("bookworm_image1.jpg", "bookworm_image2.jpg"),
            views = 800,
            author = ArticleAuthor(
            id = 5,
            firstName = "Olivia",
            middleName = "M.",
            lastName = "Taylor",
            userName = "oliviataylor",
            nickName = "oliviat",
            profileImageUrl = "oliviataylor_profile.jpg",
            useful = 35,
            answers = 18,
            tags = listOf(ArticleTag(13, "books"), ArticleTag(14, "reading")),
            bio = "A book lover sharing recommendations and insights on a wide range of genres.",
            regDate = 1637664000,
            updatedDate = 1643107200
            ),
            tags = listOf(ArticleTag(13, "books"), ArticleTag(15, "recommendations"))
        ),
        Project(
            id = 6,
            title = "CodeMaster",
            description = "An interactive coding tutorial platform for beginners to learn programming languages step by step.",
            images = listOf("codemaster_image1.jpg", "codemaster_image2.jpg"),
            views = 1200,
            author = ArticleAuthor(
                id = 6,
                firstName = "Daniel",
                middleName = "K.",
                lastName = "Wright",
                userName = "danielwright",
                nickName = "danielw",
                profileImageUrl = "danielwright_profile.jpg",
                useful = 25,
                answers = 10,
                tags = listOf(ArticleTag(16, "programming"), ArticleTag(17, "education")),
                bio = "A software engineer passionate about teaching coding to beginners.",
                regDate = 1635379200,
                updatedDate = 1643462400
            ),
            tags = listOf(ArticleTag(16, "programming"), ArticleTag(18, "tutorials"))
        ),
        Project(
            id = 7,
            title = "Fashionista",
            description = "A fashion inspiration app that provides outfit ideas, style tips, and trend forecasts.",
            images = listOf("fashionista_image1.jpg", "fashionista_image2.jpg"),
            views = 900,
            author = ArticleAuthor(
                id = 7,
                firstName = "Isabella",
                middleName = "L.",
                lastName = "Anderson",
                userName = "isabellaanderson",
                nickName = "isabellaa",
                profileImageUrl = "isabellaanderson_profile.jpg",
                useful = 20,
                answers = 8,
                tags = listOf(ArticleTag(19, "fashion"), ArticleTag(20, "style")),
                bio = "A fashion enthusiast exploring the latest trends and sharing style inspiration.",
                regDate = 1634803200,
                updatedDate = 1644652800
            ),
            tags = listOf(ArticleTag(19, "fashion"), ArticleTag(21, "inspiration"))
        ),
        Project(
            id = 8,
            title = "TravelExplorer",
            description = "A travel app that helps users plan their trips, discover hidden gems, and share travel experiences.",
            images = listOf("travelexplorer_image1.jpg", "travelexplorer_image2.jpg"),
            views = 1500,
            author = ArticleAuthor(
                id = 8,
                firstName = "Liam",
                middleName = "J.",
                lastName = "Martinez",
                userName = "liammartinez",
                nickName = "liamm",
                profileImageUrl = "liammartinez_profile.jpg",
                useful = 30,
                answers = 10,
                tags = listOf(ArticleTag(22, "travel"), ArticleTag(23, "exploration")),
                bio = "A passionate traveler sharing stories and recommendations from around the world.",
                regDate = 1631904000,
                updatedDate = 1644326400
            ),
            tags = listOf(ArticleTag(22, "travel"), ArticleTag(24, "planning"))
        )
    )

    CodeHubScreen(
        title = ctx.getString(R.string.projects_title),
        appBarModifier = Modifier
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(projects) { project ->
                ProjectCard(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    project = project
                )
            }
        }
    }

}