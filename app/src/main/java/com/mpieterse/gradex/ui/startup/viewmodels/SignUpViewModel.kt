package com.mpieterse.gradex.ui.startup.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpieterse.gradex.core.daos.DegreeDao
import com.mpieterse.gradex.core.daos.StudentDao
import com.mpieterse.gradex.core.daos.TermDao
import com.mpieterse.gradex.core.models.data.Degree
import com.mpieterse.gradex.core.models.data.Student
import com.mpieterse.gradex.core.models.data.Term
import com.mpieterse.gradex.core.services.AuthService
import com.mpieterse.gradex.core.utils.AuthValidator
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.ui.shared.models.UiState
import com.mpieterse.gradex.ui.shared.models.UiState.Failure
import com.mpieterse.gradex.ui.shared.models.UiState.Loading
import com.mpieterse.gradex.ui.shared.models.UiState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authService: AuthService,
    private val studentDao: StudentDao,
    private val degreeDao: DegreeDao,
    private val termDao: TermDao,
) : ViewModel() {
    companion object {
        private const val TAG = "SignUpViewModel"
    }


// --- Fields


    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState


// --- Contracts


    fun signUp(
        email: String, defaultPassword: String, confirmPassword: String
    ) = viewModelScope.launch {
        try { // Validate input
            validateCredentials(email, defaultPassword, confirmPassword)
        } catch (e: IllegalArgumentException) {
            Clogger.d(
                TAG, "Caught validation errors"
            )

            _uiState.value = Failure(e.message.toString())
            return@launch
        }

        _uiState.value = Loading
        Clogger.i(
            TAG, "Signing-up user with email: $email"
        )

        // Authenticate

        runCatching {
            val milliseconds = 3_000L
            withTimeout(milliseconds) {
                authService.signUpAsync(email, defaultPassword)
            }
        }.apply {
            onSuccess { user ->
                Clogger.d(
                    TAG, "Attempt to authenticate returned a success!"
                )

                seedDefaultValues()
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


    fun sendVerificationEmail() = viewModelScope.launch {
        runCatching {
            val milliseconds = 3_000L
            withTimeout(milliseconds) {
                authService.sendVerificationEmailAsync()
            }
        }.apply {
            onFailure { exception ->
                Clogger.d(
                    TAG, "Failed to send verification email"
                )

                _uiState.value = Failure(
                    exception.message.toString()
                )
            }
        }
    }


    fun getUserEmail(): String? = authService.getCurrentUser()?.email


// --- Internals


    private fun seedDefaultValues() = viewModelScope.launch {
        val student = Student(authId = authService.getCurrentUser()!!.uid)
        val degree = Degree(
            name = "Default",
            studentId = student.id
        )

        studentDao.upsert(student)
        degreeDao.upsert(degree)

        termDao.upsert(
            Term(
                name = "Semester 1",
                degreeId = degree.id
            )
        )

        termDao.upsert(
            Term(
                name = "Semester 2",
                degreeId = degree.id
            )
        )
    }


    private fun validateCredentials(
        email: String, defaultPassword: String, confirmPassword: String
    ) {
        require(AuthValidator.isValidEAddress(email)) {
            "Email Address is Invalid"
        }

        // Validate passwords

        require(AuthValidator.isValidPassword(defaultPassword)) {
            "Created Password is Invalid"
        }

        require(AuthValidator.isValidPassword(confirmPassword)) {
            "Confirm Password is Invalid"
        }

        require(defaultPassword == confirmPassword) {
            "The Passwords do not Match"
        }
    }
}