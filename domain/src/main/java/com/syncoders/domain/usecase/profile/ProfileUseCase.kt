package com.syncoders.domain.usecase.profile

import com.syncoders.domain.model.auth.User
import com.syncoders.domain.utills.ResultState

interface ProfileUseCase {
    suspend fun getProfile(userId: String) : ResultState<User?>
    suspend fun logout(): ResultState<Unit>
}