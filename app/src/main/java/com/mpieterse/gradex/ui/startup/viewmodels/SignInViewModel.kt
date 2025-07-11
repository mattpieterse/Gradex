package com.mpieterse.gradex.ui.startup.viewmodels

import androidx.lifecycle.ViewModel
import com.mpieterse.gradex.core.services.AuthService

class SignInViewModel(
    private val authService: AuthService = AuthService()
) : ViewModel() {
    companion object {
        private const val TAG = "SignInViewModel"
    }
}