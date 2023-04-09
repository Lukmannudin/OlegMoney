package com.lukmannudin.olegmoney.ui.data.user

import retrofit2.http.GET

interface UserService {

    @GET("login/user")
    fun login(username: String, password: String): User

}