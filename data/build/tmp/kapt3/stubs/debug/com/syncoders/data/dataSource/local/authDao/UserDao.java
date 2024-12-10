package com.syncoders.data.dataSource.local.authDao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e0\rH\'J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/syncoders/data/dataSource/local/authDao/UserDao;", "", "authenticateUser", "Lcom/syncoders/data/model/entity/UserEntity;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUser", "", "user", "(Lcom/syncoders/data/model/entity/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllUsers", "Lkotlinx/coroutines/flow/Flow;", "", "getUserByEmail", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserById", "id", "insertAndGetUser", "insertUser", "", "updateUser", "data_debug"})
@androidx.room.Dao
public abstract interface UserDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull
    com.syncoders.data.model.entity.UserEntity user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Transaction
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertAndGetUser(@org.jetbrains.annotations.NotNull
    com.syncoders.data.model.entity.UserEntity user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.syncoders.data.model.entity.UserEntity> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull
    com.syncoders.data.model.entity.UserEntity user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteUser(@org.jetbrains.annotations.NotNull
    com.syncoders.data.model.entity.UserEntity user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM AUTH_USER_MASTER WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.syncoders.data.model.entity.UserEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM auth_user_master WHERE email = :email")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserByEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.syncoders.data.model.entity.UserEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM auth_user_master")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.syncoders.data.model.entity.UserEntity>> getAllUsers();
    
    @androidx.room.Query(value = "SELECT * FROM auth_user_master WHERE email = :email AND password = :password")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object authenticateUser(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.syncoders.data.model.entity.UserEntity> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @androidx.room.Transaction
        @org.jetbrains.annotations.Nullable
        public static java.lang.Object insertAndGetUser(@org.jetbrains.annotations.NotNull
        com.syncoders.data.dataSource.local.authDao.UserDao $this, @org.jetbrains.annotations.NotNull
        com.syncoders.data.model.entity.UserEntity user, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super com.syncoders.data.model.entity.UserEntity> $completion) {
            return null;
        }
    }
}