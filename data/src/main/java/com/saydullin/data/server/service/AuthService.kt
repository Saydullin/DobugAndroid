package com.saydullin.data.server.service

import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.user.User
import com.saydullin.domain.model.user.UserAuthenticated
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/signIn")
    fun create(@Body user: User): Call<MainResponse<UserAuthenticated>>

    @POST("/signOut")
    fun deactivate(@Body user: User): Call<MainResponse<Unit>>

}