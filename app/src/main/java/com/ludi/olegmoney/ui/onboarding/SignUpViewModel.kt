package com.ludi.olegmoney.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.ludi.olegmoney.data.Resource
import com.ludi.olegmoney.data.user.SignUpRequest
import com.ludi.olegmoney.data.user.User
import com.ludi.olegmoney.data.user.UserNetworkDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userNetworkDataSource: UserNetworkDataSource
) : ViewModel() {

    private val _signUpState: MutableStateFlow<SignUpState?> = MutableStateFlow(null)
    val signUpState: StateFlow<SignUpState?> = _signUpState

    var mGoogleSignInClient: GoogleSignInClient? = null

    fun signUp(signUpRequest: SignUpRequest) {
        _signUpState.value = SignUpState.OnLoading

        viewModelScope.launch {
            val response = userNetworkDataSource.signUp(signUpRequest)
            if (response is Resource.Success) {
                _signUpState.value = SignUpState.OnSuccess(response.data!!)
            } else {
                _signUpState.value = SignUpState.OnError(response.message)
            }
        }
    }
}

sealed class SignUpState {
    object OnLoading : SignUpState()
    data class OnSuccess(val user: User) : SignUpState()
    data class OnError(val message: String?) : SignUpState()
}