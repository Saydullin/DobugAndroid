package com.saydullin.codehub.data.repository

import com.saydullin.codehub.data.db.dao.ArticleDao
import com.saydullin.codehub.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    val articleDao: ArticleDao,
) : ArticleRepository {



}


