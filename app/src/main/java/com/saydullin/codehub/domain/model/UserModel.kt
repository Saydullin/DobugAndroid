package com.saydullin.codehub.domain.model

data class UserModel(
    val id: Int,
    val username: String,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val registrationDate: Long,
    val courses: List<Course>
)


