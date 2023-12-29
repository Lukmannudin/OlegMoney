package com.ludi.olegmoney.data.user.request

import com.squareup.moshi.Json

data class SignUpRequest(

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "email")
    val email: String,

    @field:Json(name = "password")
    val password: String,

    @field:Json(name = "google_id")
    var googleId: String? = null,

    @field:Json(name = "avatar_url")
    var avatarUrl: String? = null
)