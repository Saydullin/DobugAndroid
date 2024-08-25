package com.saydullin.data.server.service

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.response.Paging
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostService {

    @GET("posts")
    fun getAll(): Call<MainResponse<Paging<Post>>>

    @GET("post/{id}")
    fun getById(@Path("id") id: Int): Call<MainResponse<Post?>>

    @POST("/add/post")
    fun savePost(@Body post: Post): Call<Unit>

}