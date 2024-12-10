package com.syncoders.data.repository.auth


import com.syncoders.data.dataSource.local.authDao.UserDao
import com.syncoders.data.model.entity.UserEntity
import com.syncoders.data.model.toDomain
import com.syncoders.domain.model.auth.User
import com.syncoders.domain.repository.auth.AuthRepository
import com.syncoders.domain.utills.ResultState
import com.syncoders.tmobileevaluation.data.remote.auth.AuthApiClient

import javax.inject.Inject

class AuthRepositoryImpl  @Inject constructor(
    private val authApiClient: AuthApiClient,
    private val userDao: UserDao
) : AuthRepository {
    override suspend fun login(emailId: String, password: String): ResultState<User?> {
        // Authenticate user using local Room database
        val userEntity = userDao.getUserByEmail(emailId)

        return when {
            userEntity == null -> {
                // Email does not exist
                ResultState.Failure(message = "No account found with this email.")
            }
            userEntity.password != password -> {
                // Password is incorrect
                ResultState.Failure(message = "Incorrect password. Please try again.")
            }
            else -> {
                // Successful authentication
                ResultState.Success(
                    message = "Login successful.",
                    data = userEntity.toDomain()
                )
            }
        }
    }

    override suspend fun signUp(
        name: String,
        phone: String,
        emailId: String,
        password: String,
    ): ResultState<User?> {
        return try {
            val userEntity = userDao.insertAndGetUser(
                UserEntity(name = name, mobileNo = phone, email = emailId, password = password)
            )
            if(userEntity!=null){
            ResultState.Success(
                message = "Registration successful",
                data = userEntity.toDomain()
            )}else{
                ResultState.Failure(message = "User registration failed")
            }
        } catch (e: IllegalArgumentException) {
            ResultState.Failure(message = e.message ?: "User registration failed")
        } catch (e: Exception) {
            ResultState.Failure(message = "An unexpected error occurred: ${e.message}")
        }
    }
}