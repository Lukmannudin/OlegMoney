package com.lukmannudin.olegmoney.usecase

import com.lukmannudin.olegmoney.data.user.UserNetworkDataSource

class LoginUseCase(
    val userNetworkDataSource: UserNetworkDataSource
) {
    fun invoke() {

    }

    data class Param(
        val name: String,
        val email: String,
        val googleId: String? = null
    )
}