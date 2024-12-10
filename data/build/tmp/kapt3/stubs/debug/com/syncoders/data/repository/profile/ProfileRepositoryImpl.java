package com.syncoders.data.repository.profile;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ!\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/syncoders/data/repository/profile/ProfileRepositoryImpl;", "Lcom/syncoders/domain/repository/profile/ProfileRepository;", "sharedPreferencesHelper", "Lcom/syncoders/data/dataSource/sharedPreferences/SharedPreferencesHelper;", "authApiClient", "Lcom/syncoders/tmobileevaluation/data/remote/auth/AuthApiClient;", "userDao", "Lcom/syncoders/data/dataSource/local/authDao/UserDao;", "(Lcom/syncoders/data/dataSource/sharedPreferences/SharedPreferencesHelper;Lcom/syncoders/tmobileevaluation/data/remote/auth/AuthApiClient;Lcom/syncoders/data/dataSource/local/authDao/UserDao;)V", "getProfile", "Lcom/syncoders/domain/utills/ResultState;", "Lcom/syncoders/domain/model/auth/User;", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logOut", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class ProfileRepositoryImpl implements com.syncoders.domain.repository.profile.ProfileRepository {
    @org.jetbrains.annotations.NotNull
    private final com.syncoders.data.dataSource.sharedPreferences.SharedPreferencesHelper sharedPreferencesHelper = null;
    @org.jetbrains.annotations.NotNull
    private final com.syncoders.tmobileevaluation.data.remote.auth.AuthApiClient authApiClient = null;
    @org.jetbrains.annotations.NotNull
    private final com.syncoders.data.dataSource.local.authDao.UserDao userDao = null;
    
    @javax.inject.Inject
    public ProfileRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.syncoders.data.dataSource.sharedPreferences.SharedPreferencesHelper sharedPreferencesHelper, @org.jetbrains.annotations.NotNull
    com.syncoders.tmobileevaluation.data.remote.auth.AuthApiClient authApiClient, @org.jetbrains.annotations.NotNull
    com.syncoders.data.dataSource.local.authDao.UserDao userDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getProfile(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.syncoders.domain.utills.ResultState<com.syncoders.domain.model.auth.User>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object logOut(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.syncoders.domain.utills.ResultState<kotlin.Unit>> $completion) {
        return null;
    }
}