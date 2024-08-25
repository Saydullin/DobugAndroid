package com.saydullin.domain.repository

import com.saydullin.domain.util.response.Resource
import com.saydullin.domain.model.article.bug.BugArticle

interface BugArticleRepository {

    suspend fun getBugArticlesAPI(): Resource<List<BugArticle>>

    suspend fun getBugArticleDB(): Resource<List<BugArticle>>

    suspend fun saveBugArticles(articles: List<BugArticle>): Resource<Unit>

}


