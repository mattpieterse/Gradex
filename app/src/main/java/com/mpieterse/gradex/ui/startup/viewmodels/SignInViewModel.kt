package com.mpieterse.gradex.ui.startup.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpieterse.gradex.core.services.AuthService
import com.mpieterse.gradex.core.utils.AuthValidator
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.ui.shared.models.UiState
import com.mpieterse.gradex.ui.shared.models.UiState.Failure
import com.mpieterse.gradex.ui.shared.models.UiState.Loading
import com.mpieterse.gradex.ui.shared.models.UiState.Success
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

class SignInViewModel(
    private val authService: AuthService = AuthService()
) : ViewModel() {
    companion object {
        private const val TAG = "SignInViewModel"
    }


    // --- Fields


    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState


    // --- Contracts


    fun signIn(
        email: String, password: String
    ) = viewModelScope.launch {
        try { // Validate input
            requireValidCredentials(email, password)
        } catch (e: IllegalArgumentException) {
            Clogger.d(
                TAG, "Caught validation errors"
            )

            _uiState.value = Failure(e.message.toString())
        }


        _uiState.value = Loading
        Clogger.i(
            TAG, "Signing-in user with email: $email"
        )

        // Authenticate

        runCatching {
            val milliseconds = 3_000L
            withTimeout(milliseconds) {
                authService.signInAsync(email, password)
            }
        }.apply {
            onSuccess { user ->
                Clogger.d(
                    TAG, "Attempt to authenticate returned a success!"
                )

                _uiState.value = Success
            }

            onFailure { exception ->
                Clogger.d(
                    TAG, "Attempt to authenticate returned a failure!"
                )

                _uiState.value = Failure(
                    exception.message.toString()
                )
            }
        }
    }


    fun isCurrentUserVerified(): Boolean = authService.getCurrentUser()?.isEmailVerified ?: false


    // --- Internals


    private fun requireValidCredentials(
        email: String, password: String
    ) {
        require(AuthValidator.isValidEAddress(email)) {
            "Email Address is Invalid"
        }

        require(AuthValidator.isValidPassword(password)) {
            "Password is Invalid"
        }
    }
}