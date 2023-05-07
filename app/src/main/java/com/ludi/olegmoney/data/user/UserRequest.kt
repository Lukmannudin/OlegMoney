package com.ludi.olegmoney.data.user

import com.squareup.moshi.Json

data class SignUpRequest(

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "email")
    val email: String,

    @field:Json(name = "password")
    val password: String,

    @field:Json(name = "googleId")
    var googleId: String? = null,

    @field:Json(name = "avatarUrl")
    var avatarUrl: String? = null
)