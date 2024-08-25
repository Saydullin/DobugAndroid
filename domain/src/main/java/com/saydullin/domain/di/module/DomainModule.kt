package com.saydullin.domain.di.module

import com.saydullin.domain.config.AppConfig
import com.saydullin.domain.di.qualifiers.BaseUrl
import com.saydullin.domain.repository.PostRepository
import com.saydullin.domain.usecase.post.GetPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String {
        return AppConfig.BASE_URL
    }

    @Provides
    @Singleton
    fun provideGetPostsUseCase(
        postRepository: PostRepository
    ): GetPostsUseCase {
        return GetPostsUseCase(postRepository)
    }

}