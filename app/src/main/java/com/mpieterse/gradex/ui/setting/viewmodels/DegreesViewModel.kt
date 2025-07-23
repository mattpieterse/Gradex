package com.mpieterse.gradex.ui.setting.viewmodels

import androidx.lifecycle.ViewModel
import com.mpieterse.gradex.core.models.data.Degree
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class DegreesViewModel @Inject constructor() : ViewModel() {
    companion object {
        private const val TAG = "DegreesViewModel"
    }


// --- Contracts


    fun loadDegrees(): List<Degree> {
        val seed1 = Degree(
            name = "BSc Computer & Information Science",
            studentId = UUID.randomUUID()
        )
        
        val seed2 = Degree(
            name = "BSc Physiotherapy",
            studentId = UUID.randomUUID()
        )
        
        return listOf(
            seed1, seed2
        )
    }
}