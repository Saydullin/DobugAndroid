package com.saydullin.codehub.domain.usecase

import com.saydullin.codehub.domain.model.article.bug.BugArticle
import com.saydullin.codehub.domain.repository.BugArticleRepository
import com.saydullin.codehub.domain.util.Resource
import javax.inject.Inject

class GetBugArticleDBUseCase @Inject constructor(
    private val bugArticleRepository: BugArticleRepository
) {

    suspend fun execute(): Resource<List<BugArticle>> {
        return bugArticleRepository.getBugArticleDB()
    }

}


