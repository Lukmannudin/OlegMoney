package com.ludi.olegmoney.ui.onboarding.verification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ludi.olegmoney.data.Resource
import com.ludi.olegmoney.data.user.UserNetworkDataSource
import com.ludi.olegmoney.data.user.request.VerificationRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerificationViewModel @Inject constructor(
    private val userNetworkDataSource: UserNetworkDataSource
) : ViewModel() {

    private val _verificationUiState: MutableStateFlow<VerificationUiState> =
        MutableStateFlow(VerificationUiState.Idle)
    val verificationUiState: StateFlow<VerificationUiState> = _verificationUiState

    fun verify(
        email: String,
        code: String
    ) {
        _verificationUiState.value = VerificationUiState.OnLoading
        viewModelScope.launch {
            val response = userNetworkDataSource.verify(
                VerificationRequest(
                    email,
                    code
                )
            )

            if (response is Resource.Success) {
                _verificationUiState.value = VerificationUiState.OnSuccess
            } else {
                _verificationUiState.value = VerificationUiState.OnError(response.message)
            }
        }
    }
}

sealed class VerificationUiState {
    object OnLoading : VerificationUiState()
    object OnSuccess : VerificationUiState()
    data class OnError(val message: String?) : VerificationUiState()
    object Idle : VerificationUiState()
}
