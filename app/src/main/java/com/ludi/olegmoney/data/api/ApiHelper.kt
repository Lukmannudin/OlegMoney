package com.ludi.olegmoney.data.api

import com.ludi.olegmoney.data.Resource
import com.ludi.olegmoney.data.user.SignUpRequest
import com.ludi.olegmoney.data.user.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ApiHelper {
    suspend fun signUp(request: SignUpRequest): Resource<User>
}

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {

    override suspend fun signUp(request: SignUpRequest): Resource<User> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.signup(request)
                if (response.isSuccessful) {
                    Resource.Success(User(request.name, request.email))
                } else {
                    Resource.Error(response.message())
                }
            } catch (e: Exception) {
                Resource.Error(e.message ?: "something went wrong")
            }
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