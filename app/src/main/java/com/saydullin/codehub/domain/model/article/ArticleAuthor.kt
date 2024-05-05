package com.saydullin.codehub.domain.model.article

data class ArticleAuthor(
    val id: Int,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val userName: String,
    val nickName: String,
    val profileImageUrl: String,
    val useful: Int,
    val answers: Int,
    val tags: List<ArticleTag>,
    val registrationDate: Long,
    val updatedDate: Long,
) {

    fun getFullName(): String {
        return "$firstName $middleName $lastName".trim()
    }

}
