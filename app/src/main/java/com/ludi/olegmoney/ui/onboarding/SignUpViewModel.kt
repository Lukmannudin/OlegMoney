package com.ludi.olegmoney.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ludi.olegmoney.data.user.SignUpRequest
import com.ludi.olegmoney.data.user.UserNetworkDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userNetworkDataSource: UserNetworkDataSource
) : ViewModel() {

    fun signUp(
        name: String,
        email: String,
        password: String,
        onCall: (String) -> Unit
    ) {
        viewModelScope.launch {
            val signUpRequest = SignUpRequest(
                name,
                email,
                password
            )

            val response = userNetworkDataSource.signUp(signUpRequest)
            onCall.invoke(response.message ?: "something went wrong")
        }
    }
}