package com.ludi.olegmoney.data.api

import com.ludi.olegmoney.data.BaseResponse
import com.ludi.olegmoney.data.user.SignUpRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("v1/users/login")
    suspend fun login(username: String, password: String): Response<BaseResponse>

    @POST("v1/users/sign-up")
    suspend fun signup(@Body request: SignUpRequest): Response<BaseResponse>
}