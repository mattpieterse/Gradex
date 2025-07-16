package com.mpieterse.gradex.ui.central.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.mpieterse.gradex.R
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "HomeActivity"
    }


    private lateinit var binds: ActivityHomeBinding
    private var currentFragment: Fragment? = null


// --- Lifecycle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Clogger.d(
            TAG, "Created a new instance of the activity"
        )

        setupBindings()
        setupLayoutUi()
        setupNavigation()

        savedInstanceState ?: showNewFragment(HomeCalendarFragment())
    }


// --- Internals


    private fun setupNavigation() {
        binds.nav.setOnItemSelectedListener { item ->
            val destination = when (item.itemId) {
                R.id.nav_calendar -> HomeCalendarFragment()
                R.id.nav_grades -> HomeGradesFragment()
                R.id.nav_overview -> HomeOverviewFragment()
                else -> null
            }

            destination?.let {
                if (destination != currentFragment) {
                    showNewFragment(it)
                }
            }

            true
        }
    }


    private fun showNewFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        when (currentFragment == null) {
            true -> transaction.replace(binds.container.id, fragment)
            else -> transaction.replace(binds.container.id, fragment)
        }

        currentFragment = fragment
        transaction.commit()
    }


// --- UI


    private fun setupBindings() {
        binds = ActivityHomeBinding.inflate(layoutInflater)
    }


    private fun setupLayoutUi() {
        setContentView(binds.root)
        enableEdgeToEdge()

        // Apply system-bar insets to the root view
        ViewCompat.setOnApplyWindowInsetsListener(binds.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
    }
}