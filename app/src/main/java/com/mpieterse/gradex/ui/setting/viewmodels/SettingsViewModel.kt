package com.mpieterse.gradex.ui.setting.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(): ViewModel() {
    companion object {
        private const val TAG = "SettingsViewModel"
    }
}