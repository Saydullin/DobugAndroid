package com.saydullin.data.repository.auth

import android.util.Log
import com.saydullin.data.server.service.AuthService
import com.saydullin.domain.model.user.User
import com.saydullin.domain.repository.auth.AuthRepository
import com.saydullin.domain.util.response.Resource
import com.saydullin.domain.util.response.StatusType
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService
): AuthRepository {

    override suspend fun create(user: User): Resource<Unit> {
        return try {
            val response = authService.create(user)
            val serverResponse = response.execute()

            Log.e("sady", "serverResponse sign up: ${serverResponse.raw()}")

            if (serverResponse.isSuccessful && serverResponse.body() != null) {
                return Resource.Success(Unit)
            }

            Resource.Error(
                status = StatusType.SIGN_IN_ERROR
            )
        } catch (e: Exception) {
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