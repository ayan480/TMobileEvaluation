package com.syncoders.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.syncoders.data.dataSource.local.AUTH_USER_TABLE


@Entity(tableName = AUTH_USER_TABLE)
public data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val name: String,
    val email: String,
    val mobileNo: String,
    val profilePic: String? = null,
    val password: String? = null,
    val createdAt: String? = null ,
    val updatedAt: String? = null,
)
