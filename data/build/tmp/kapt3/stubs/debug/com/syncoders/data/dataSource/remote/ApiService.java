package com.syncoders.data.dataSource.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lcom/syncoders/data/dataSource/remote/ApiService;", "", "signup", "Lcom/syncoders/androidupskillpreparation/domain/model/auth/SignupResponse;", "registrationDTO", "Lcom/syncoders/tmobileevaluation/data/model/auth/SignupRequest;", "(Lcom/syncoders/tmobileevaluation/data/model/auth/SignupRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "api/signup")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object signup(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.syncoders.tmobileevaluation.data.model.auth.SignupRequest registrationDTO, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.syncoders.androidupskillpreparation.domain.model.auth.SignupResponse> $completion);
}