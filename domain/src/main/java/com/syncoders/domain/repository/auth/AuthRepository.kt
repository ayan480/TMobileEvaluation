package com.syncoders.domain.repository.auth

import com.syncoders.domain.model.auth.User
import com.syncoders.domain.utills.ResultState

interface AuthRepository {
    suspend fun login(emailId: String, password: String) : ResultState<User?>
    suspend fun signUp(name: String, phone: String, emailId: String, password: String) : ResultState<User?>
}