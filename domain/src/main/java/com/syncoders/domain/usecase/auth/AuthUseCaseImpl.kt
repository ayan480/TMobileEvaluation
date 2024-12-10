package com.syncoders.domain.usecase.auth

import com.syncoders.domain.model.auth.User
import com.syncoders.domain.repository.auth.AuthRepository
import com.syncoders.domain.utills.ResultState
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(private val authRepository: AuthRepository): AuthUseCase {
    override suspend fun login(emailId: String, password: String): ResultState<User?> {
       return authRepository.login(emailId,password)
    }

    override suspend fun signUp(
        name: String,
        phone: String,
        emailId: String,
        password: String,
    ): ResultState<User?> {
        return authRepository.signUp(name= name, phone= phone, password = password, emailId = emailId)
    }
}