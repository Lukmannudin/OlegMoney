package com.ludi.olegmoney.data;

import com.squareup.moshi.Json

data class BaseResponse<I>(

//    @field:Json(name = "status")
//    val status: String? = null,

    @field:Json(name = "message")
    val message: String? = null,

    @field:Json(name = "data")
    val data: I? = null
)