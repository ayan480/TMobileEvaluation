package com.syncoders.domain.model.auth

data class User(
    val id: String,
    val name: String,
    val email: String,
    val mobileNo: String,
    val profilePic: String? = null
)
