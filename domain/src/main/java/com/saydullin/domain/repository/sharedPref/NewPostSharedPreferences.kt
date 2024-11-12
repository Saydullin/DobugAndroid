package com.saydullin.domain.repository.sharedPref

import kotlinx.coroutines.flow.Flow

interface NewPostSharedPreferences {

    suspend fun saveTags(tag: String)

    fun getTags(): Flow<String>

    suspend fun saveTitle(title: String)

    fun getTitle(): Flow<String>

    suspend fun saveDescription(description: String)

    fun getDescription(): Flow<String>

}