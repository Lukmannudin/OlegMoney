package com.ludi.olegmoney.data.user.request

import com.squareup.moshi.Json

data class VerificationRequest(

    @field:Json(name = "name")
    val email: String,

    @field:Json(name = "verify_code")
    val verifyCode: String
)