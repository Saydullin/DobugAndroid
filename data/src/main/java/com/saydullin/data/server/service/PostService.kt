package com.saydullin.data.server.service

import com.saydullin.domain.model.post.Post
import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.response.Paging
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {

    @GET("posts")
    fun getAll(): Call<MainResponse<Paging<Post>>>

    @GET("post")
    fun getById(@Query("id") id: Long): Call<MainResponse<Post?>>

    @POST("post")
    fun savePost(@Body post: Post): Call<Unit>

}