package com.syncoders.domain.usecase.auth

import com.syncoders.domain.model.auth.User
import com.syncoders.domain.utills.ResultState

interface AuthUseCase {
    suspend fun login(emailId: String, password: String) : ResultState<User?>
    suspend fun signUp(name: String, phone: String, emailId: String, password: String) : ResultState<User?>
}