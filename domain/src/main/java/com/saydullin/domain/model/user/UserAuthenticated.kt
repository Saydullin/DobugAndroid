package com.saydullin.domain.model.user

data class UserAuthenticated(
    val id: Long,
    val username: String,
    val password: String,
    val email: String,
    val regDate: Long,
)
