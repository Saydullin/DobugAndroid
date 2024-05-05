package com.saydullin.codehub.di

import android.content.Context
import androidx.room.Room
import com.saydullin.codehub.data.db.AppDatabase
import com.saydullin.codehub.data.db.dao.ArticleDao
import com.saydullin.codehub.data.repository.ArticleRepositoryImpl
import com.saydullin.codehub.data.repository.BugArticleRepositoryImpl
import com.saydullin.codehub.domain.repository.ArticleRepository
import com.saydullin.codehub.domain.repository.BugArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
        return BugArticleRepositoryImpl(
        )
    }

}


