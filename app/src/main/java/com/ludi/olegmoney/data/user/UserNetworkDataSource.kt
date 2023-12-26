package com.ludi.olegmoney.data.user

import com.ludi.olegmoney.data.Resource
import com.ludi.olegmoney.data.api.ApiHelper
import javax.inject.Inject

class UserNetworkDataSource @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun signUp(signUpRequest: SignUpRequest): Resource<User> {
        return apiHelper.signUp(signUpRequest)
    }

    suspend fun login(loginRequest: LoginRequest): Resource<String> {
        return apiHelper.login(loginRequest)
    }
}