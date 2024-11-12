package com.saydullin.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TagEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val type: String,
)
