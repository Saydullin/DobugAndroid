package com.saydullin.data.sharedPref

import android.content.Context
import com.saydullin.domain.repository.sharedPref.NewPostSharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewPostSharedPreferencesImpl @Inject constructor(
    @ApplicationContext private val context: Context,
): NewPostSharedPreferences {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
            name = "new post",
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            )
        )

        private val NEW_POST_TITLE = stringPreferencesKey("new_post_title")
        private val NEW_POST_DESCRIPTION = stringPreferencesKey("new_post_description")
        private val NEW_POST_TAGS = stringPreferencesKey("new_post_tags")
    }

    override suspend fun saveTags(tag: String) {
        context.dataStore.edit { it[NEW_POST_TAGS] = tag }
    }

    override fun getTags(): Flow<String> {
        return context.dataStore.data.map { it[NEW_POST_TAGS] ?: "" }
    }

    override suspend fun saveTitle(title: String) {
        context.dataStore.edit { it[NEW_POST_TITLE] = title }
    }

    override fun getTitle(): Flow<String> {
        return context.dataStore.data.map { it[NEW_POST_TITLE] ?: "" }
    }

    override suspend fun saveDescription(description: String) {
        context.dataStore.edit { it[NEW_POST_DESCRIPTION] = description }
    }

    override fun getDescription(): Flow<String> {
        return context.dataStore.data.map { it[NEW_POST_DESCRIPTION] ?: "" }
    }

}