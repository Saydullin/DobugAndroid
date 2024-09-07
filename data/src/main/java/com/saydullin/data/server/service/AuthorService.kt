package com.saydullin.data.server.service

import com.saydullin.domain.model.post.Author
import com.saydullin.domain.model.response.MainResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthorService {

    @GET("/author")
    fun getAuthor(): Call<MainResponse<Author>>

    @POST("/author")
    fun saveAuthor(@Body author: Author): Call<MainResponse<Unit>>

}