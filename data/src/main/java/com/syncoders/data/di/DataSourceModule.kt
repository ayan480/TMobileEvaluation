package com.syncoders.data.di


import com.syncoders.tmobileevaluation.data.remote.auth.AuthApiClient
import com.syncoders.tmobileevaluation.data.remote.auth.AuthApiClientImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    @Singleton
    fun dataSourceImpl(authApiClient: AuthApiClientImpl): AuthApiClient
}