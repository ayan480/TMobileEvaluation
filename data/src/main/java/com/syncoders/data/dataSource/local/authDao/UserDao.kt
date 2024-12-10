package com.syncoders.data.dataSource.local.authDao

import androidx.room.*

import com.syncoders.data.dataSource.local.AUTH_USER_TABLE
import com.syncoders.data.model.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity): Long

    @Transaction
    suspend fun insertAndGetUser(user: UserEntity): UserEntity? {
        val existingUser = getUserByEmail(user.email)
        if (existingUser != null) {
            throw IllegalArgumentException("User with this email already exists.")
        }
        val userId = insertUser(user)
        return getUserById(userId.toInt().toString())
    }

    @Update
    suspend fun updateUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("SELECT * FROM AUTH_USER_MASTER WHERE id = :id")
    suspend fun getUserById(id: String): UserEntity?

    @Query("SELECT * FROM auth_user_master WHERE email = :email")
    suspend fun getUserByEmail(email: String): UserEntity?

    @Query("SELECT * FROM $AUTH_USER_TABLE")
    fun getAllUsers(): Flow<List<UserEntity>>

    @Query("SELECT * FROM $AUTH_USER_TABLE WHERE email = :email AND password = :password")
    suspend fun authenticateUser(email: String, password: String): UserEntity?
}

