package com.mpieterse.gradex.ui.central.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeCalendarFragmentViewModel @Inject constructor() : ViewModel() {
    companion object {
        private const val TAG = "HomeCalendarFragmentViewModel"
    }
}