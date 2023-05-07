package com.ludi.olegmoney.data.api

sealed class NetworkResponse {
    object Success : NetworkResponse()
    object Created : NetworkResponse()
    object AuthorizationRequired : NetworkResponse()
    object BadRequest : NetworkResponse()
    object ReferenceFailure : NetworkResponse()
    object InternalServerError : NetworkResponse()
    object Undefined : NetworkResponse()
}