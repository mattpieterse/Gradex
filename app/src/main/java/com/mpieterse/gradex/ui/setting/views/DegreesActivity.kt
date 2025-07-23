package com.mpieterse.gradex.ui.setting.views

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ActivityDegreesBinding
import com.mpieterse.gradex.ui.setting.adapters.DegreeAdapter
import com.mpieterse.gradex.ui.setting.viewmodels.DegreesViewModel
import com.mpieterse.gradex.ui.shared.models.Clickable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DegreesActivity : AppCompatActivity(), Clickable {
    companion object {
        private const val TAG = "DegreesActivity"
    }


    private lateinit var adapter: DegreeAdapter
    private lateinit var binds: ActivityDegreesBinding
    private val model: DegreesViewModel by viewModels()


// --- Lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Clogger.d(
            TAG, "Created a new instance of the activity"
        )

        setupBindings()
        setupLayoutUi()
        setupTouchListeners()
        updateView()
    }


// --- Internals


    private fun updateView() {
        adapter = DegreeAdapter()
        binds.rvDegrees.layoutManager = LinearLayoutManager(this)
        binds.rvDegrees.adapter = adapter
        adapter.update(
            model.loadDegrees()
        )
    }


// --- Event Handlers


    override fun setupTouchListeners() {
        binds.fab.setOnClickListener(this)
    }


    override fun onClick(view: View?) = when (view?.id) {
        binds.fab.id -> { /* TODO */
        }

        else -> {
            Clogger.w(
                TAG, "Unhandled on-click for: ${view?.id}"
            )
        }
    }


// --- UI


    private fun setupBindings() {
        binds = ActivityDegreesBinding.inflate(layoutInflater)
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