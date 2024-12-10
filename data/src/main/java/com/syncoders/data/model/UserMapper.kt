package com.syncoders.data.model


import com.syncoders.data.model.entity.UserEntity
import com.syncoders.domain.model.auth.User

fun UserEntity.toDomain(): User {
    return User(id = id.toString(), name = name, email = email,mobileNo =mobileNo)
}

fun User.toEntity(): UserEntity {
    return UserEntity(id = id.toInt(), name = name, email = email,mobileNo = mobileNo)
}