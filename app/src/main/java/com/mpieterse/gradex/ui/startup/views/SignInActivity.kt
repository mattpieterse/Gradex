package com.mpieterse.gradex.ui.startup.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ActivitySignInBinding
import com.mpieterse.gradex.ui.startup.viewmodels.SignInViewModel

class SignInActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "SignInActivity"
    }


    private lateinit var binds: ActivitySignInBinding
    private lateinit var model: SignInViewModel


    // --- Lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Clogger.d(
            TAG, "Created a new instance of the activity"
        )

        setupBindings()
        setupLayoutUi()

        model = ViewModelProvider(this)[SignInViewModel::class.java]

        observe()
    }


    // --- ViewModel


    private fun observe() {}


    // --- UI


    private fun setupBindings() {
        binds = ActivitySignInBinding.inflate(layoutInflater)
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