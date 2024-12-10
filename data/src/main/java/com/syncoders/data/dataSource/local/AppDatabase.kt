package com.syncoders.data.dataSource.local



import androidx.room.Database
import androidx.room.RoomDatabase
import com.syncoders.data.dataSource.local.authDao.UserDao
import com.syncoders.data.model.entity.UserEntity




@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}