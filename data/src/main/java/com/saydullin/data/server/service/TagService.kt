package com.saydullin.data.server.service

import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.tag.Tag
import retrofit2.Call
import retrofit2.http.GET

interface TagService {

    @GET("tags")
    fun getAllTags(): Call<MainResponse<List<Tag>>>

}