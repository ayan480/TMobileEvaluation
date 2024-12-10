package com.syncoders.data.dataSource.sharedPreferences;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\tJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tJ\u0010\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/syncoders/data/dataSource/sharedPreferences/SharedPreferencesHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "rememberMeSharedPreferences", "Landroid/content/SharedPreferences;", "sharedPreferences", "getLoginId", "", "getLoginPassword", "getString", "key", "getUser", "Lcom/syncoders/domain/model/auth/User;", "getUserId", "isLoggedIn", "", "logout", "", "putString", "value", "saveLoginId", "id", "saveLoginPassword", "password", "saveUser", "user", "data_debug"})
public final class SharedPreferencesHelper {
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences rememberMeSharedPreferences = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences sharedPreferences = null;
    
    @javax.inject.Inject
    public SharedPreferencesHelper(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void saveLoginId(@org.jetbrains.annotations.Nullable
    java.lang.String id) {
    }
    
    public final void saveLoginPassword(@org.jetbrains.annotations.Nullable
    java.lang.String password) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLoginId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLoginPassword() {
        return null;
    }
    
    public final void putString(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getString(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
        return null;
    }
    
    public final void saveUser(@org.jetbrains.annotations.NotNull
    com.syncoders.domain.model.auth.User user) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.syncoders.domain.model.auth.User getUser() {
        return null;
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final void logout() {
    }
}