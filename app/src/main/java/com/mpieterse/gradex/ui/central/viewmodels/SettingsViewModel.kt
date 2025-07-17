package com.mpieterse.gradex.ui.central.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class SettingsViewModel: ViewModel() {
    companion object {
        private const val TAG = "SettingsViewModel"
    }
}