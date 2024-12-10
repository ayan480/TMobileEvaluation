package com.syncoders.data.model.dto.auth

data class LoginDTO (
    val emailOrPhone: String,
    val password: String,
)