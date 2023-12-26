package com.ludi.olegmoney.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInClient
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

    private val _user: MutableStateFlow<User?> = MutableStateFlow(null)
    val user: StateFlow<User?> = _user

    var mGoogleSignInClient: GoogleSignInClient? = null

    fun signUp(
        name: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            val signUpRequest = SignUpRequest(
                name,
                email,
                password
            )

            val response = userNetworkDataSource.signUp(signUpRequest)
            _user.value = response.data
        }
    }

    fun signUpWithGoogle() {

    }
}