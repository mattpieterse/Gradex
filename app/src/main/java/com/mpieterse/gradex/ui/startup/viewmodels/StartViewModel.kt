package com.mpieterse.gradex.ui.startup.viewmodels

import androidx.lifecycle.ViewModel
import com.mpieterse.gradex.core.services.AuthService

class StartViewModel(
    private val authService: AuthService = AuthService()
) : ViewModel() {
    companion object {
        private const val TAG = "StartViewModel"
    }
}