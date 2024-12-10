package com.syncoders.domain.usecase.profile

import android.app.backup.SharedPreferencesBackupHelper
import com.syncoders.domain.model.auth.User
import com.syncoders.domain.repository.auth.AuthRepository
import com.syncoders.domain.repository.profile.ProfileRepository
import com.syncoders.domain.utills.ResultState
import javax.inject.Inject

class ProfileUseCaseImpl @Inject constructor(private val profileRepository: ProfileRepository): ProfileUseCase {
    override suspend fun getProfile(userId: String): ResultState<User?> {
       return profileRepository.getProfile(userId)
    }

    override suspend fun logout(): ResultState<Unit> {
        return  profileRepository.logOut()
    }

}