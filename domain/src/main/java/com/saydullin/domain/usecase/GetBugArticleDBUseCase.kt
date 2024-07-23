package com.saydullin.domain.usecase

import com.saydullin.domain.model.article.bug.BugArticle
import com.saydullin.domain.repository.BugArticleRepository
import com.saydullin.domain.util.Resource
import javax.inject.Inject

class GetBugArticleDBUseCase @Inject constructor(
    private val bugArticleRepository: BugArticleRepository
) {

    suspend fun execute(): Resource<List<BugArticle>> {
        return bugArticleRepository.getBugArticleDB()
    }

}


