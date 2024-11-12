package com.saydullin.domain.repository.auth

import com.saydullin.domain.model.response.MainResponse
import com.saydullin.domain.model.user.User
import com.saydullin.domain.model.user.UserAuthenticated
import com.saydullin.domain.util.response.Resource

interface AuthRepository {

    suspend fun create(user: User): Resource<MainResponse<UserAuthenticated>>

    suspend fun deactivate(user: User): Resource<Unit>

}