package com.syncoders.domain.repository.profile

import com.syncoders.domain.model.auth.User
import com.syncoders.domain.utills.ResultState

interface ProfileRepository {

    suspend fun getProfile(userId:String) : ResultState<User?>
    suspend fun logOut() : ResultState<Unit>
}