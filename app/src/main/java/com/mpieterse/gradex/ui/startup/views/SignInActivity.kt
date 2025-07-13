package com.mpieterse.gradex.ui.startup.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ActivitySignInBinding
import com.mpieterse.gradex.ui.central.views.HomeActivity
import com.mpieterse.gradex.ui.shared.models.Clickable
import com.mpieterse.gradex.ui.shared.models.UiState.Failure
import com.mpieterse.gradex.ui.shared.models.UiState.Loading
import com.mpieterse.gradex.ui.shared.models.UiState.Success
import com.mpieterse.gradex.ui.startup.viewmodels.SignInViewModel

class SignInActivity : AppCompatActivity(), Clickable {
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
        setupTouchListeners()

        model = ViewModelProvider(this)[SignInViewModel::class.java]

        observe()
    }


    // --- ViewModel


    private fun observe() = model.uiState.observe(this) { state ->
        when (state) {
            is Loading -> {
                load()
                Clogger.d(
                    TAG, "Loading..."
                )
            }

            is Success -> {
                cast()
                Clogger.d(
                    TAG, "Success..."
                )

                startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                finishAffinity()
            }

            is Failure -> {
                cast()
                Clogger.d(
                    TAG, "Failure..."
                )

                Toast.makeText(
                    this, state.message, Toast.LENGTH_LONG
                ).show()
            }

            else -> {
                Clogger.w(
                    TAG, "Unhandled state: ${state.javaClass::class.java.simpleName}"
                )
            }
        }
    }


    // --- Internals


    private fun tryAuthenticateCredentials() {
        val email = binds.etIdentity.text.toString().trim()
        val password = binds.etPassword.text.toString().trim()
        model.signIn(
            email, password
        )
    }


    private fun load() {} // TODO


    private fun cast() {} // TODO


    // --- Event Handlers


    override fun setupTouchListeners() {
        binds.btSignIn.setOnClickListener(this)
        binds.tvForgotPassword.setOnClickListener(this)
    }


    override fun onClick(view: View?) = when (view?.id) {
        binds.btSignIn.id -> tryAuthenticateCredentials()
        binds.tvForgotPassword.id -> {} // TODO
        else -> {
            Clogger.w(
                TAG, "Unhandled on-click for: ${view?.id}"
            )
        }
    }


    // --- UI


    private fun setupBindings() {
        binds = ActivitySignInBinding.inflate(layoutInflater)
    }


    private fun setupLayoutUi() {
        setContentView(binds.root)
        enableEdgeToEdge()

        // Apply system-bar insets to the root view
        ViewCompat.setOnApplyWindowInsetsListener(binds.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)

            // Add system-bottom-bar sized padding to the container
            val params = binds.svContainer.layoutParams as FrameLayout.LayoutParams
            params.bottomMargin = systemBars.bottom
            binds.svContainer.layoutParams = params

            insets
        }
    }
}