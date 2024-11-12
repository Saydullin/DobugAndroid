package com.saydullin.domain.usecase.auth

import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.user.User
import com.saydullin.domain.model.user.UserAuthenticated
import com.saydullin.domain.repository.auth.AuthRepository
import com.saydullin.domain.util.response.Resource
import javax.inject.Inject

class CreateAccountUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend fun execute(user: User): Resource<MainResponse<UserAuthenticated>> {
        return authRepository.create(user)
    }

}