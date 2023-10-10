package com.ludi.olegmoney.usecase

import com.ludi.olegmoney.data.user.UserNetworkDataSource

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