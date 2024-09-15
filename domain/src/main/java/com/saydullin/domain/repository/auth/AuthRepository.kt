package com.saydullin.domain.repository.auth

import com.saydullin.domain.model.user.User
import com.saydullin.domain.util.response.Resource

interface AuthRepository {

    suspend fun create(user: User): Resource<Unit>

    suspend fun deactivate(user: User): Resource<Unit>

}