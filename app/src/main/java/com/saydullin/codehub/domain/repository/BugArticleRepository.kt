package com.saydullin.codehub.domain.repository

import com.saydullin.codehub.domain.util.Resource
import com.saydullin.codehub.domain.model.article.bug.BugArticle

interface BugArticleRepository {

    suspend fun getBugArticlesAPI(): Resource<List<BugArticle>>

    suspend fun getBugArticleDB(): Resource<List<BugArticle>>

    suspend fun saveBugArticles(articles: List<BugArticle>): Resource<Unit>

}


