package com.saydullin.data.di.module

import android.content.Context
import androidx.room.Room
import com.saydullin.data.database.AppDatabase
import com.saydullin.data.database.converter.IntListConverter
import com.saydullin.data.database.dao.ArticleDao
import com.saydullin.data.database.dao.PostDao
import com.saydullin.data.di.mapper.post.PostEntityToPostMapper
import com.saydullin.data.di.mapper.post.PostToPostEntityMapper
import com.saydullin.data.repository.ArticleRepositoryImpl
import com.saydullin.data.repository.BugArticleRepositoryImpl
import com.saydullin.data.repository.auth.AuthRepositoryImpl
import com.saydullin.data.repository.post.PostLocalRepositoryImpl
import com.saydullin.data.repository.post.PostServerRepositoryImpl
import com.saydullin.data.server.RetrofitBuilder
import com.saydullin.data.server.service.AuthService
import com.saydullin.data.server.service.PostService
import com.saydullin.domain.di.qualifiers.BaseUrl
import com.saydullin.domain.repository.ArticleRepository
import com.saydullin.domain.repository.BugArticleRepository
import com.saydullin.domain.repository.auth.AuthRepository
import com.saydullin.domain.repository.post.PostLocalRepository
import com.saydullin.domain.repository.post.PostServerRepository
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
            .addTypeConverter(IntListConverter())
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
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideArticleDao(appDatabase: AppDatabase): ArticleDao {
        return appDatabase.articleDao()
    }

    @Provides
    @Singleton
    fun providePostDao(appDatabase: AppDatabase): PostDao {
        return appDatabase.postDao()
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
    fun postLocalRepository(
        postDao: PostDao,
        postEntityToPostMapper: PostEntityToPostMapper,
        postToPostEntityMapper: PostToPostEntityMapper
    ): PostLocalRepository {
        return PostLocalRepositoryImpl(
            postDao = postDao,
            postEntityToPostMapper = postEntityToPostMapper,
            postToPostEntityMapper = postToPostEntityMapper,
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
    ): PostServerRepository {
        return PostServerRepositoryImpl(postService)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        authService: AuthService
    ): AuthRepository {
        return AuthRepositoryImpl(authService)
    }

}


