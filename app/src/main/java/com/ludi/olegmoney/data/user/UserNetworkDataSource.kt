package com.ludi.olegmoney.data.user

import javax.inject.Inject

class UserNetworkDataSource @Inject constructor(private val userService: UserService) {

    fun login(username: String, password: String) {
        userService.login(username, password)
    }
}