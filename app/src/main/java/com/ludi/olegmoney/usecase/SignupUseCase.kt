package com.ludi.olegmoney.usecase

import com.ludi.olegmoney.data.user.UserNetworkDataSource

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