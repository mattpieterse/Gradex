package com.mpieterse.gradex.ui.startup.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mpieterse.gradex.core.services.AuthService
import com.mpieterse.gradex.ui.shared.models.UiState
import com.mpieterse.gradex.ui.shared.models.UiState.Failure
import com.mpieterse.gradex.ui.shared.models.UiState.Loading
import com.mpieterse.gradex.ui.shared.models.UiState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val authService: AuthService
) : ViewModel() {
    companion object {
        private const val TAG = "StartViewModel"
    }


    // --- Fields


    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState


    // --- Contracts


    fun authenticate() {
        _uiState.value = Loading
        when (authService.isUserSignedIn()) {
            true -> _uiState.value = Success
            else -> _uiState.value = Failure(
                "There is no user currently signed-in"
            )
        }
    }
}