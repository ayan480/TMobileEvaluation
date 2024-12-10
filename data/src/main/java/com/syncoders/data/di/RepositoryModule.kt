package com.syncoders.data.di

import com.syncoders.domain.repository.auth.AuthRepository
import com.syncoders.data.repository.auth.AuthRepositoryImpl
import com.syncoders.data.repository.profile.ProfileRepositoryImpl
import com.syncoders.domain.repository.profile.ProfileRepository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindAuthRepositoryImpl(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    fun bindProfileRepositoryImpl(profileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository
}
