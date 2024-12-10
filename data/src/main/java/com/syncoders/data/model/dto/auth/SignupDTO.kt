package com.syncoders.data.model.dto.auth

data class SignupDTO (
    val email: String,
    val mobileNo: String,
    val name: String,
    val password: String,
    val profilePic: String? = null,
)