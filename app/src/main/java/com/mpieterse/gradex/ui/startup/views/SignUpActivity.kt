package com.mpieterse.gradex.ui.startup.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ActivitySignUpBinding
import com.mpieterse.gradex.ui.startup.viewmodels.SignUpViewModel

class SignUpActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "SignUpActivity"
    }


    private lateinit var binds: ActivitySignUpBinding
    private lateinit var model: SignUpViewModel


    // --- Lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Clogger.d(
            TAG, "Created a new instance of the activity"
        )

        setupBindings()
        setupLayoutUi()

        model = ViewModelProvider(this)[SignUpViewModel::class.java]

        observe()
    }


    // --- ViewModel


    private fun observe() {}


    // --- UI


    private fun setupBindings() {
        binds = ActivitySignUpBinding.inflate(layoutInflater)
    }


    private fun setupLayoutUi() {
        setContentView(binds.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binds.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}