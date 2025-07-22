package com.mpieterse.gradex.ui.central.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    companion object {
        private const val TAG = "HomeViewModel"
    }


// --- Fields


    var screenTitle = MutableLiveData<String>()
}