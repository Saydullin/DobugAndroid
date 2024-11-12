package com.saydullin.data.repository.auth

import android.util.Log
import com.saydullin.data.server.service.AuthService
import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.user.User
import com.saydullin.domain.model.user.UserAuthenticated
import com.saydullin.domain.repository.auth.AuthRepository
import com.saydullin.domain.util.response.Resource
import com.saydullin.domain.util.response.StatusType
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService
): AuthRepository {

    override suspend fun create(user: User): Resource<MainResponse<UserAuthenticated>> {
        return try {
            val response = authService.create(user)
            val serverResponse = response.execute()

            Log.e("sady", "serverResponse sign in: ${serverResponse.raw()}")

            if (serverResponse.isSuccessful && serverResponse.body() != null) {
                val body = serverResponse.body()

                return Resource.Success(body)
            }

            Resource.Error(
                status = StatusType.SIGN_IN_ERROR
            )
        } catch (e: Exception) {
            Log.e("sady", "serverResponse catch sign in: ${e.message}")
            Resource.Error(
                e = e,
                status = StatusType.SIGN_IN_ERROR
            )
        }
    }

    override suspend fun deactivate(user: User): Resource<Unit> {
        TODO("Not yet implemented")
    }

}