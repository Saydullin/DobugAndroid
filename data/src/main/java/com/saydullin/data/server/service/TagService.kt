package com.saydullin.data.server.service

import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.tag.Tag
import retrofit2.Response
import retrofit2.http.GET

interface TagService {

    @GET("/tags")
    fun getAllTags(): Response<MainResponse<List<Tag>>>

}