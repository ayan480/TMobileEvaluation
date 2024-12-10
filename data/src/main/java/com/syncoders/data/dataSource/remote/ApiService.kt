package com.syncoders.data.dataSource.remote

import com.syncoders.androidupskillpreparation.domain.model.auth.SignupResponse
import com.syncoders.tmobileevaluation.data.model.auth.SignupRequest

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/signup")
    suspend fun signup(@Body registrationDTO: SignupRequest): SignupResponse

}