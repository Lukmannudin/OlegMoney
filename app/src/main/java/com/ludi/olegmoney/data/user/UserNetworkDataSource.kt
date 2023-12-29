package com.ludi.olegmoney.data.user

import com.ludi.olegmoney.data.Resource
import com.ludi.olegmoney.data.api.ApiHelper
import com.ludi.olegmoney.data.user.request.LoginRequest
import com.ludi.olegmoney.data.user.request.SignUpRequest
import com.ludi.olegmoney.data.user.request.VerificationRequest
import javax.inject.Inject

class UserNetworkDataSource @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun signUp(signUpRequest: SignUpRequest): Resource<User> {
        return apiHelper.signUp(signUpRequest)
    }

    suspend fun login(loginRequest: LoginRequest): Resource<String> {
        return apiHelper.login(loginRequest)
    }

    suspend fun verify(verificationRequest: VerificationRequest): Resource<Unit> {
        return apiHelper.verify(verificationRequest)
    }
}