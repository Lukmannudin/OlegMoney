package com.ludi.olegmoney.data.api

import com.ludi.olegmoney.data.Resource
import com.ludi.olegmoney.data.user.ErrorResponse
import com.ludi.olegmoney.data.user.LoginRequest
import com.ludi.olegmoney.data.user.SignUpRequest
import com.ludi.olegmoney.data.user.User
import com.squareup.moshi.Moshi
import javax.inject.Inject

interface ApiHelper {
    suspend fun signUp(request: SignUpRequest): Resource<User>

    suspend fun login(request: LoginRequest): Resource<String>
}

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {

    override suspend fun signUp(request: SignUpRequest): Resource<User> {
        return try {
            val response = apiService.signup(request)
            if (response.isSuccessful) {
                Resource.Success(User(request.name, request.email))
            } else {
                val moshi: Moshi = Moshi.Builder().build()

                val adapter = moshi.adapter(ErrorResponse::class.java)
                val errorResponse = response.errorBody()?.string()?.let { adapter.fromJson(it) }
                Resource.Error(errorResponse?.message)
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "something went wrong")
        }
    }

    override suspend fun login(request: LoginRequest): Resource<String> {
        return try {
            val response = apiService.login(request)
            if (response.isSuccessful) {
                Resource.Success(response.body()?.data?.token!!)
            } else {
                Resource.Error(response.body()?.message ?: "")
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "something went wrong")
        }
    }

    private fun Int.convertToResponse(): NetworkResponse {
        return when (this) {
            200 -> NetworkResponse.Success
            201 -> NetworkResponse.Created
            400 -> NetworkResponse.BadRequest
            401 -> NetworkResponse.AuthorizationRequired
            500 -> NetworkResponse.InternalServerError
            else -> NetworkResponse.Undefined
        }
    }
}