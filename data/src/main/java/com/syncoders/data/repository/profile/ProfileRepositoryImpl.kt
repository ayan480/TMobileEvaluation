package com.syncoders.data.repository.profile


import com.syncoders.data.dataSource.local.authDao.UserDao
import com.syncoders.data.dataSource.sharedPreferences.SharedPreferencesHelper
import com.syncoders.data.model.entity.UserEntity
import com.syncoders.data.model.toDomain
import com.syncoders.domain.model.auth.User
import com.syncoders.domain.repository.auth.AuthRepository
import com.syncoders.domain.repository.profile.ProfileRepository
import com.syncoders.domain.utills.ResultState
import com.syncoders.tmobileevaluation.data.remote.auth.AuthApiClient

import javax.inject.Inject

class ProfileRepositoryImpl  @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    private val authApiClient: AuthApiClient,
    private val userDao: UserDao
) : ProfileRepository {
    override suspend fun getProfile(userId: String): ResultState<User?> {
        // Authenticate user using local Room database
        val userEntity = userDao.getUserById(userId)

        return when {
            userEntity == null -> {
                // Email does not exist
                ResultState.Failure(message = "No account found with this email.")
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

    override suspend fun logOut(): ResultState<Unit> {
        return try {
            // Clear user data from shared preferences or database
            sharedPreferencesHelper.logout()
            ResultState.Success(message = "Logout Successfully!")
        } catch (e: Exception) {
            ResultState.Failure(message = "Logout Successfully!")
        }
    }

}