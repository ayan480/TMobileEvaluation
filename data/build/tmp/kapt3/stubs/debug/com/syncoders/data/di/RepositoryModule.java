package com.syncoders.data.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'\u00a8\u0006\n"}, d2 = {"Lcom/syncoders/data/di/RepositoryModule;", "", "bindAuthRepositoryImpl", "Lcom/syncoders/domain/repository/auth/AuthRepository;", "authRepositoryImpl", "Lcom/syncoders/data/repository/auth/AuthRepositoryImpl;", "bindProfileRepositoryImpl", "Lcom/syncoders/domain/repository/profile/ProfileRepository;", "profileRepositoryImpl", "Lcom/syncoders/data/repository/profile/ProfileRepositoryImpl;", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract interface RepositoryModule {
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract com.syncoders.domain.repository.auth.AuthRepository bindAuthRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.syncoders.data.repository.auth.AuthRepositoryImpl authRepositoryImpl);
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract com.syncoders.domain.repository.profile.ProfileRepository bindProfileRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.syncoders.data.repository.profile.ProfileRepositoryImpl profileRepositoryImpl);
}