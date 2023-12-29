package com.ludi.olegmoney.data.user.request

import com.squareup.moshi.Json

data class VerificationRequest(
    @Json(name = "email") val email: String, @Json(name = "verify_code") val verifyCode: String
)