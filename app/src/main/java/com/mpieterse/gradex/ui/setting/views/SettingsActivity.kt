package com.mpieterse.gradex.ui.setting.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ActivitySettingsBinding
import com.mpieterse.gradex.ui.setting.viewmodels.SettingsViewModel
import com.mpieterse.gradex.ui.shared.models.Clickable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsActivity : AppCompatActivity(), Clickable {
    companion object {
        private const val TAG = "SettingsActivity"
    }


    private lateinit var binds: ActivitySettingsBinding
    private val model: SettingsViewModel by viewModels()


// --- Lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Clogger.d(
            TAG, "Created a new instance of the activity"
        )

        setupBindings()
        setupLayoutUi()
        setupTouchListeners()
        observe()
    }


// --- ViewModel


    private fun observe() {
        /* TODO */
    }


// --- Event Handlers


    override fun setupTouchListeners() {
        binds.btNavigateToDegrees.setOnClickListener(this)
    }


    override fun onClick(view: View?) = when (view?.id) {
        binds.btNavigateToDegrees.id -> {
            startActivity(Intent(this, DegreesActivity::class.java))
        }

        else -> {
            Clogger.w(
                TAG, "Unhandled on-click for: ${view?.id}"
            )
        }
    }


// --- UI


    private fun setupBindings() {
        binds = ActivitySettingsBinding.inflate(layoutInflater)
    }


    private fun setupLayoutUi() {
        setContentView(binds.root)
        enableEdgeToEdge()

        // Apply system-bar insets to the root view
        ViewCompat.setOnApplyWindowInsetsListener(binds.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}