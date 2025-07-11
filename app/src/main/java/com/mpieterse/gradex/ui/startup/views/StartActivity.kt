package com.mpieterse.gradex.ui.startup.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ActivityStartBinding
import com.mpieterse.gradex.ui.startup.viewmodels.StartViewModel

class StartActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "StartActivity"
    }


    private lateinit var binds: ActivityStartBinding
    private lateinit var model: StartViewModel


    // --- Lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Clogger.d(
            TAG, "Created a new instance of the activity"
        )

        setupBindings()
        setupLayoutUi()

        model = ViewModelProvider(this)[StartViewModel::class.java]

        observe()
    }


    // --- ViewModel


    private fun observe() {}


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