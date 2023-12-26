package com.ludi.olegmoney.data.user

import com.squareup.moshi.Json

data class LoginResponse(
    @field:Json(name = "token") val token: String
)