package com.mpieterse.gradex.ui.startup.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mpieterse.gradex.R
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ActivitySignUpBinding
import com.mpieterse.gradex.databinding.ModalBottomSheetFaqBinding
import com.mpieterse.gradex.ui.central.views.HomeActivity
import com.mpieterse.gradex.ui.shared.models.Clickable
import com.mpieterse.gradex.ui.shared.models.UiState.Failure
import com.mpieterse.gradex.ui.shared.models.UiState.Loading
import com.mpieterse.gradex.ui.shared.models.UiState.Success
import com.mpieterse.gradex.ui.startup.sheets.FaqBottomSheet
import com.mpieterse.gradex.ui.startup.viewmodels.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity(), Clickable {
    companion object {
        private const val TAG = "SignUpActivity"
    }


    private lateinit var binds: ActivitySignUpBinding
    private val model: SignUpViewModel by viewModels()


    // --- Lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Clogger.d(
            TAG, "Created a new instance of the activity"
        )

        setupBindings()
        setupLayoutUi()
        setupTouchListeners()

        //model = ViewModelProvider(this)[SignUpViewModel::class.java]

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

                model.sendVerificationEmail()
                showDialogForVerificationEmail()
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
        val defaultPassword = binds.etPasswordDefault.text.toString().trim()
        val confirmPassword = binds.etPasswordConfirm.text.toString().trim()
        model.signUp(
            email, defaultPassword, confirmPassword
        )
    }


    private fun load() {} // TODO


    private fun cast() {} // TODO


    // --- Dialogs


    private fun showDialogForVerificationEmail() {
        MaterialAlertDialogBuilder(this).apply {
            setTitle("Verification")
            setMessage("We've sent an email to your inbox at ${model.getUserEmail()}. \nFollow the link to verify your account.")
            setIcon(R.drawable.xic_x24_uic_line_envelope_shield)

            // Configs

            setCancelable(false)

            // Buttons

            setPositiveButton("Confirm") { _, _ ->
                startActivity(Intent(this@SignUpActivity, HomeActivity::class.java))
                finish()
            }
        }.show()
    }


    // --- Event Handlers


    override fun setupTouchListeners() {
        binds.btSignUp.setOnClickListener(this)
        binds.tvSignIn.setOnClickListener(this)
        binds.tvFaq.setOnClickListener(this)
    }


    override fun onClick(view: View?) = when (view?.id) {
        binds.btSignUp.id -> tryAuthenticateCredentials()
        binds.tvSignIn.id -> {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }

        binds.tvFaq.id -> {
            FaqBottomSheet().show(
                supportFragmentManager, FaqBottomSheet.TAG
            )
        } // TODO
        else -> {
            Clogger.w(
                TAG, "Unhandled on-click for: ${view?.id}"
            )
        }
    }


    // --- UI


    private fun setupBindings() {
        binds = ActivitySignUpBinding.inflate(layoutInflater)
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