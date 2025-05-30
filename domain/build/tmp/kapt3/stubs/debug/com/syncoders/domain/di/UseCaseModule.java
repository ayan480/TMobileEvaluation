package com.syncoders.domain.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/syncoders/domain/di/UseCaseModule;", "", "()V", "provideAuthUseCase", "Lcom/syncoders/domain/usecase/auth/AuthUseCase;", "authRepository", "Lcom/syncoders/domain/repository/auth/AuthRepository;", "provideProfileUseCase", "Lcom/syncoders/domain/usecase/profile/ProfileUseCase;", "profileRepository", "Lcom/syncoders/domain/repository/profile/ProfileRepository;", "domain_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class UseCaseModule {
    
    public UseCaseModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.syncoders.domain.usecase.auth.AuthUseCase provideAuthUseCase(@org.jetbrains.annotations.NotNull
    com.syncoders.domain.repository.auth.AuthRepository authRepository) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.syncoders.domain.usecase.profile.ProfileUseCase provideProfileUseCase(@org.jetbrains.annotations.NotNull
    com.syncoders.domain.repository.profile.ProfileRepository profileRepository) {
        return null;
    }
}