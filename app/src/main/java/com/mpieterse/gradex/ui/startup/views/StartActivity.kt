package com.mpieterse.gradex.ui.startup.views

import android.content.Intent
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ActivityStartBinding
import com.mpieterse.gradex.ui.central.views.HomeActivity
import com.mpieterse.gradex.ui.shared.models.UiState.Failure
import com.mpieterse.gradex.ui.shared.models.UiState.Success
import com.mpieterse.gradex.ui.startup.viewmodels.StartViewModel

class StartActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "StartActivity"
    }


    private lateinit var binds: ActivityStartBinding
    private lateinit var model: StartViewModel
    
    
    private var authenticating: Boolean = true


    // --- Lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Clogger.d(
            TAG, "Created a new instance of the activity"
        )

        persistSplashScreenUntilAuthChecksComplete()
        setupBindings()
        setupLayoutUi()

        model = ViewModelProvider(this)[StartViewModel::class.java]

        observe()

        model.authenticate()
    }


    // --- ViewModel


    private fun observe() = model.uiState.observe(this) { state ->
        when (state) {
            is Success -> {
                authenticating = false
                startActivity(Intent(this, HomeActivity::class.java))
                finishAffinity()
            }

            is Failure -> {
                authenticating = false
            }

            else -> {
                Clogger.w(
                    TAG, "Unhandled state: ${state.javaClass::class.java.simpleName}"
                )
            }
        }
    }
    
    
    // --- Internals
    
    
    private fun persistSplashScreenUntilAuthChecksComplete() {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {
            authenticating
        }
    }


    // --- UI


    private fun setupBindings() {
        binds = ActivityStartBinding.inflate(layoutInflater)
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