package com.ludi.olegmoney.ui.onboarding.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ludi.olegmoney.data.Resource
import com.ludi.olegmoney.data.user.request.LoginRequest
import com.ludi.olegmoney.data.user.UserNetworkDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userNetworkDataSource: UserNetworkDataSource
) : ViewModel() {

    private val _loginState : MutableStateFlow<LoginUiState?> = MutableStateFlow(null)
    val loginUiState: StateFlow<LoginUiState?> = _loginState

    fun login(email: String, password: String) {
        _loginState.value = LoginUiState.OnLoading
        viewModelScope.launch {
            val resource = userNetworkDataSource.login(
                LoginRequest(email, password)
            )

            if (resource is Resource.Success) {
                _loginState.value = LoginUiState.OnSuccess
            } else {
                _loginState.value = LoginUiState.OnError
            }
        }
    }
}

sealed class LoginUiState {
    object OnLoading : LoginUiState()
    object OnSuccess : LoginUiState()
    object OnError : LoginUiState()

}