package com.syncoders.domain.di


import com.syncoders.domain.repository.auth.AuthRepository
import com.syncoders.domain.repository.profile.ProfileRepository
import com.syncoders.domain.usecase.auth.AuthUseCase
import com.syncoders.domain.usecase.auth.AuthUseCaseImpl
import com.syncoders.domain.usecase.profile.ProfileUseCase
import com.syncoders.domain.usecase.profile.ProfileUseCaseImpl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule{

    @Provides
    @Singleton
    fun provideAuthUseCase(authRepository: AuthRepository): AuthUseCase = AuthUseCaseImpl(authRepository)

 @Provides
    @Singleton
    fun provideProfileUseCase(profileRepository: ProfileRepository): ProfileUseCase = ProfileUseCaseImpl(profileRepository)
}