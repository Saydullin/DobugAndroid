package com.saydullin.data.repository

import com.saydullin.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    val articleDao: com.saydullin.data.database.dao.ArticleDao,
) : ArticleRepository {



}


