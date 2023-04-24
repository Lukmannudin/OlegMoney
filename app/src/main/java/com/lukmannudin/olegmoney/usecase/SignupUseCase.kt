package com.lukmannudin.olegmoney.usecase

import com.lukmannudin.olegmoney.data.user.UserNetworkDataSource

class SignupUseCase(
    private val userNetworkDataSource: UserNetworkDataSource
) {

    fun invoke() {

    }

    data class Param(
        val name: String,
        val email: String,
        val password: String,
        val avatarUrl: String? = null,
        val googleId: String? = null
    )
}