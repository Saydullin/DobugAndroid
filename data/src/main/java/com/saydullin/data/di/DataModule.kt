package com.saydullin.data.di

import android.content.Context
import androidx.room.Room
import com.saydullin.data.database.AppDatabase
import com.saydullin.data.database.dao.ArticleDao
import com.saydullin.data.repository.ArticleRepositoryImpl
import com.saydullin.data.repository.BugArticleRepositoryImpl
import com.saydullin.data.repository.PostRepositoryImpl
import com.saydullin.data.server.RetrofitBuilder
import com.saydullin.data.server.service.PostService
import com.saydullin.domain.di.qualifiers.BaseUrl
import com.saydullin.domain.repository.ArticleRepository
import com.saydullin.domain.repository.BugArticleRepository
import com.saydullin.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "CodeHubDatabase"
        )
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        @BaseUrl baseUrl: String
    ): Retrofit {
        return RetrofitBuilder.get(baseUrl)
    }

    @Provides
    @Singleton
    fun providePostService(retrofit: Retrofit): PostService {
        return retrofit.create(PostService::class.java)
    }

    @Provides
    @Singleton
    fun provideArticleDao(appDatabase: AppDatabase): ArticleDao {
        return appDatabase.articleDao()
    }

    @Provides
    @Singleton
    fun provideArticleRepository(
        articleDao: ArticleDao
    ): ArticleRepository {
        return ArticleRepositoryImpl(
            articleDao = articleDao,
        )
    }

    @Provides
    @Singleton
    fun provideBugArticleRepository(
    ): BugArticleRepository {
        return BugArticleRepositoryImpl()
    }

    @Provides
    @Singleton
    fun providePostRepository(
        postService: PostService
    ): PostRepository {
        return PostRepositoryImpl(postService)
    }

}


