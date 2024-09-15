package com.saydullin.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AuthorEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val firstName: String,
    val middleName: String,
    val lastName: String,
)
