package com.saydullin.codehub.domain.model.article

data class ArticleAuthor(
    val id: Int,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val userName: String,
    val nickName: String,
    val profileImageUrl: String,
    val registrationDate: Long,
) {

    fun getFullName(): String {
        return "$firstName $middleName $lastName".trim()
    }

}


