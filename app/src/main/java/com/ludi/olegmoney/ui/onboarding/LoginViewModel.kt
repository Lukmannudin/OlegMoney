package com.ludi.olegmoney.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ludi.olegmoney.data.user.LoginRequest
import com.ludi.olegmoney.data.user.UserNetworkDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userNetworkDataSource: UserNetworkDataSource
) : ViewModel() {

    fun login(email: String, password: String) {
        viewModelScope.launch {
            userNetworkDataSource.login(
                LoginRequest(email, password)
            )
        }
    }
}