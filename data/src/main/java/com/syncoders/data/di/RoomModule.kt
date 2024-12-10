package com.syncoders.data.di


import android.content.Context
import androidx.room.Room
import com.syncoders.data.dataSource.local.APP_DATABASE_NAME
import com.syncoders.data.dataSource.local.AppDatabase
import com.syncoders.data.dataSource.local.authDao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            APP_DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.getUserDao()
    }
}