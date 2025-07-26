package com.mpieterse.gradex.ui.setting.viewmodels

import androidx.lifecycle.ViewModel
import com.mpieterse.gradex.core.daos.StudentDao
import com.mpieterse.gradex.core.models.data.Degree
import com.mpieterse.gradex.core.services.AuthService
import com.mpieterse.gradex.core.utils.Clogger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DegreesViewModel @Inject constructor(
    private val authService: AuthService,
    private val dao: StudentDao
) : ViewModel() {
    companion object {
        private const val TAG = "DegreesViewModel"
    }


// --- Contracts


    suspend fun loadDegrees(): List<Degree> {
        Clogger.i(
            TAG, "Seeding..."
        )

        val student = dao.fetchOneFullStudentByAuthenticationId(
            authService.getCurrentUser()!!.uid
        )
        return student!!.degrees.map { it.entity }
    }
}