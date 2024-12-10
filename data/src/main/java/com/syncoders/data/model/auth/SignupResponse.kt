package com.syncoders.androidupskillpreparation.domain.model.auth

import com.syncoders.domain.model.auth.User

data class SignupResponse(
    val success: Boolean,
    val data: User?,
    val message: String,
)
