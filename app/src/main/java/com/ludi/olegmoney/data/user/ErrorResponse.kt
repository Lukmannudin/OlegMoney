package com.ludi.olegmoney.data.user

import com.squareup.moshi.Json

data class ErrorResponse(
    @field:Json(name = "message") val message: String? = null,
    @field:Json(name = "version") val version: String? = null,
    @field:Json(name = "status") val status: Boolean? = null
)