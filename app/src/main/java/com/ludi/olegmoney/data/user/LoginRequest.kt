package com.ludi.olegmoney.data.user

import com.squareup.moshi.Json

data class LoginRequest(
    @field:Json(name = "email")
    val email: String,

    @field:Json(name = "password")
    val password: String
)