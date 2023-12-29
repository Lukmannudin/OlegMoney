package com.ludi.olegmoney.data.api

import com.ludi.olegmoney.data.BaseResponse
import com.ludi.olegmoney.data.user.request.LoginRequest
import com.ludi.olegmoney.data.user.LoginResponse
import com.ludi.olegmoney.data.user.request.SignUpRequest
import com.ludi.olegmoney.data.user.request.VerificationRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("v1/users/login")
    suspend fun login(@Body request: LoginRequest): Response<BaseResponse<LoginResponse>>

    @POST("v1/users/sign-up")
    suspend fun signup(@Body request: SignUpRequest): Response<BaseResponse<Any>>

    @POST("users/verify-account")
    suspend fun verify(@Body request: VerificationRequest): Response<BaseResponse<Any>>
}