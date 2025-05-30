package com.syncoders.data.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/syncoders/data/di/RoomModule;", "", "()V", "provideDatabase", "Lcom/syncoders/data/dataSource/local/AppDatabase;", "context", "Landroid/content/Context;", "provideUserDao", "Lcom/syncoders/data/dataSource/local/authDao/UserDao;", "database", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class RoomModule {
    @org.jetbrains.annotations.NotNull
    public static final com.syncoders.data.di.RoomModule INSTANCE = null;
    
    private RoomModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.syncoders.data.dataSource.local.AppDatabase provideDatabase(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.syncoders.data.dataSource.local.authDao.UserDao provideUserDao(@org.jetbrains.annotations.NotNull
    com.syncoders.data.dataSource.local.AppDatabase database) {
        return null;
    }
}